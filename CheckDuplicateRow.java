
public class CheckDuplicateRow {
	public boolean checkRow(int a[][]){
		for(int i=0;i<a.length;i++){
		for(int j=0;j<a.length-2;j++){
			if(a[i][j]==a[i][j+1])
				return false;
			}
		}
		
	return true;
	}
}

