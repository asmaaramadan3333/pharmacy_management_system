package graduation.demo.pharmacymanagementsystem.rest;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import graduation.demo.pharmacymanagementsystem.service.AzureBlobAdapterServiceImpl;

@RestController
@RequestMapping("/blob")
public class AzureController {
	@Autowired
    private AzureBlobAdapterServiceImpl AzureBlobAdapterServiceImpl;

	/*
	 * @PostMapping("/container") public ResponseEntity createContainer(@RequestBody
	 * String containerName){ boolean created =
	 * azureBlobAdapter.createContainer(containerName); return
	 * ResponseEntity.ok(created); }
	 */

    @PostMapping("/upload")
    public Map<String,Object> upload(@RequestParam MultipartFile multipartFile){
	    Map<String, Object> coordinates = new HashMap<>();		  

    	
    	URI url = AzureBlobAdapterServiceImpl.upload(multipartFile);
       coordinates.put("URL", ResponseEntity.ok(url));
    	
    	return coordinates;
    }

	/*
	 * @GetMapping("/blobs") public ResponseEntity getAllBlobs(@RequestParam String
	 * containerName){ List uris = azureBlobAdapter.listBlobs(containerName); return
	 * ResponseEntity.ok(uris); }
	 * 
	 * @DeleteMapping public ResponseEntity delete(@RequestParam String
	 * containerName, @RequestParam String blobName){
	 * azureBlobAdapter.deleteBlob(containerName, blobName); return
	 * ResponseEntity.ok().build(); }
	 */


}
