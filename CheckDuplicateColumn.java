
public class CheckDuplicateColumn {
	public boolean checkColumn(int a[][]){
	for(int i=0;i<a.length-2;i++){
		for(int j=0;j<a.length-2;j++){
			if(a[j][i]==a[j][i+1])
			return false;
		}
	}
		
return true;
}


}
