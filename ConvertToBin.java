public class ConvertToBin {
	public int[] convertBinary(int num){
		int a[]=new int[11];
		int b[];
		int i=0;
		while(num!=0){
			int r=num%2;
			num=num/2;
			a[i]=r;
			i++;	
		}	
		b = new int[a.length];
		for(int k = 0 ; k<a.length; k++){
			b[k] = a[a.length -1 -k];
		}
		return b;
	}
}
		
