public class ConvertToBin {
		public int[] convertBinary(int num) {
			int a[]=new int[11];
			int b[];
			int i=0;
			do{
				int r=num%2;
				num=num/2;
				a[i]=r;
				i++;
			} while(num!=0);
				b = new int[a.length];
				for(int k = 0 ; k<a.length; k++){
					b[k] = a[a.length -1 -k];
				}
			return b;
		}
}
		
