package Files.DeleteFile;

import java.io.File;

import Files.FileDetails.FileDetails;
import Files.detailListener.DetailListener;

public class deleteFile {
	
	FileDetails fd =new FileDetails();
	
	public void delete(DetailListener dl,int path,int name ,int type){
		
		File file = new File (fd.addPath(dl, path)+fd.addPath(dl, name )+fd.addPath(dl, type));
		
		if (file.exists()) {
			
			file.deleteOnExit();
			
		}
		
	}

}
