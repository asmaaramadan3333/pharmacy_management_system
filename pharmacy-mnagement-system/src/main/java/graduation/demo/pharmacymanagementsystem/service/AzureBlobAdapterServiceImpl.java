package graduation.demo.pharmacymanagementsystem.service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

import graduation.demo.pharmacymanagementsystem.dao.BeanConfigDAO;
import graduation.demo.pharmacymanagementsystem.dao.BeanConfigDAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.azure.storage.blob.BlobClient;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlobDirectory;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;
import com.microsoft.azure.storage.file.FileInputStream;


@Service
public class AzureBlobAdapterServiceImpl  {
	private BeanConfigDAO BeanConfigDAO;

	
	  @Autowired public AzureBlobAdapterServiceImpl(BeanConfigDAO theBeanConfigDAO)
	  { BeanConfigDAO= theBeanConfigDAO; }
	 

	public  URI upload(MultipartFile multipartFile) {
        URI uri = null;
      
        CloudBlockBlob blob = null;
        
        //CloudBlockBlob blob =new CloudBlockBlob(blob) ;
        try {
        	CloudBlobContainer container=  BeanConfigDAO.testBlobContainer();
        	blob = container.getBlockBlobReference(multipartFile.getOriginalFilename());
            blob.upload(multipartFile.getInputStream(), -1);
            uri = blob.getUri();
            System.out.println("done");
        } catch (StorageException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return uri;
    }



}
