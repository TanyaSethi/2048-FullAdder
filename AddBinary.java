
public class AddBinary {
	public int sum[]=new int[11];
public int add(int a[],int b[])
{ 
	int carry=0,i;
	for(i=10;i>=0;--i)
	{
	sum[i]=(a[i]+b[i]+carry)%2;
	carry=(a[i]+b[i]+carry)/2;
	}
	//for(i=0;i<=10;++i)
		//System.out.print(sum[i]);
	BinToDec obj1=new BinToDec();
	int d=obj1.convert(sum);
	return d;
}
}
/*class MainClass
{
	public static void main(String args[])
	{
		AddBinary obj=new AddBinary();
		int a[]={0,0,0,0,0,0,0,0,1,0,0,0},b[]={0,0,0,0,0,0,0,0,0,0,1,0};
		AddBinary.add(a,b);
		
	}
}*/