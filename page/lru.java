import java.io.*;
public class lru
{
	 public static void main(String[] args) throws Exception
	 {
		 int f,fault=0,i,j,k,p,hit=0,l,m,h;
		 int page[];
		 int frame[];
		 int recently[];
		 boolean flag=true;
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 System.out.println("Give no of Frames:");
		 f=Integer.parseInt(br.readLine());
		 System.out.println("No of Pages:");
		 p=Integer.parseInt(br.readLine());
		 page=new int[p];
		 frame=new int[f];
		 recently=new int[f];
		 for(i=0;i<f;i++)
		 {
			 frame[i]=-1;
			 recently[i]=-1;
		 }
		 System.out.println("Give Pages:");
		 for(i=0;i<p;i++)
		 {
			 page[i]=Integer.parseInt(br.readLine());
		 }
		 for(i=0;i<p;i++)
		 {
			 flag=true;
			 for(j=0;j<f;j++)
			 {
				 if(frame[j]==page[i])
				 {
					 flag=false;
					 recently[j]=-1;
					 hit=hit+1;
					 for(m=0;m<f;m++)
					 {
						 if(m!=j)
						 {
							 recently[m]=recently[m]+1;
						 }
						 
					 }
					 break;
				 }
			 }
			 int max=recently[0];
			 if(flag)
			 {
				 int index = 0;
				 for(k=0;k<f;k++)
				 {
					 if(max<recently[k])
					 {
						 max=recently[k];
						 index=k;
					 }
				 }
				 frame[index]=page[i];
				 fault=fault+1;
				 recently[index]=-1;
				 for(l=0;l<f;l++)
				 {
					 if(l!=index)
					 {
						 recently[l]=recently[l]+1;
					 }
				 }
			 }
			 System.out.print("Frames: ");
			 for(h=0;h<f;h++)
			 {
				 System.out.print(frame[h]+" ");
			 }
			 System.out.println();
		 }
		 System.out.print("No of Pagefaults :" + fault);
		 System.out.println();
		 System.out.print("No of Hits: "+ hit);
		 
	}
}	 
