package graduation.demo.pharmacymanagementsystem.dao;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

public interface BeanConfigDAO {
	public CloudBlobClient cloudBlobClient() throws URISyntaxException, StorageException, InvalidKeyException;
	 public CloudBlobContainer testBlobContainer() throws URISyntaxException, StorageException, InvalidKeyException ;
}
