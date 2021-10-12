
public class AddBinary {
	public int sum[]=new int[11];
	public int add(int a[],int b[]) { 
		int carry = 0, i = 0;
		for(i = 10; i>=0; --i) {
			sum[i] = (a[i]+b[i]+carry) % 2;
			carry = (a[i]+b[i]+carry) / 2;
		}
		BinToDec obj1 = new BinToDec();
		int d = obj1.convert(sum);
		return d;
	}
}
