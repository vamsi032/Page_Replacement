package page_replacement;
import java.io.*;
public class ovm {
       
        public static void main( String args[]) throws IOException
        {
        	 int f1=3;
             int n;
              int pages[];
              int frame1[]=new int[f1];

                BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
                boolean flag;
                int hit=0;
                int cnt[]=new int[f1];
                for(int i=0;i<f1;i++)
                {
                        frame1[i]=-1;
                        cnt[i]=0;

                }
                n=Integer.parseInt(obj.readLine());
int fault=n;
                pages=new int[n];
                for(int i=0;i<n;i++)
                {
                        pages[i]=Integer.parseInt(obj.readLine());

                }
                for(int i=0;i<n;i++)
                {
                        int page=pages[i];
                        flag=true;
                        for(int j=0;j<f1;j++)
                        {
                                if(frame1[j]==page)
                                {
                                        flag=false;
                                        hit=hit+1;
                                        break;

                                }
                        }
                        if(flag)
                        {
                                int frame;
                                for(int j=0;j<f1;j++)
                                {
                                        frame = frame1[j];
                                        if(frame==-1)
                                        {
                                        	System.out.println("Now frame is -1");
                                                frame1[j]=page;
                                                flag=false;
                                                break;
                                        }
                                }
                                if(flag)
                                {
                                        for(int j=0;j<f1;j++)
                                        {
                                                frame=frame1[j];
                                                int count=0;
                                                for(int k=i+1;k<n;k++)
                                                {
                                                        if(frame==pages[k])
                                                        {
                                                                count=count+1;
                                                        }
                                                }
                                                System.out.println("Frame is"+frame);
                                                cnt[j]=count;
                                               System.out.println("Count is"+count);
                                        }
                                        int min=cnt[0];
                                        int h=0;
                                        for(int z=1;z<f1;z++)
                                        {
                                                if(cnt[z]<min)
                                                {
                                                        min=cnt[z];
                                                        h=z;
                                                }
                                                else if (cnt[z]==min)
                                                {
                                                	for(int y=0;y<i;y++)
                                                	{
                                                		if(frame1[h]==pages[y])
                                                		{
                                                			
                                          
                                                			break;
                                                		}
                                                		else if(frame1[z]==pages[y])
                                                		{
                                                			min=cnt[z];
                                                			h=z;
                                                			break;
                                                		}
                                                	}
                                                }
                                        }
                                        frame1[h]=page;
                                        fault=fault+1;
                                }
                        }
                        System.out.println("frame:");
                        for(int u=0;u<f1;u++)
                        {

                                System.out.print(frame1[u]+" ");
                        }
                        System.out.println();
                }
        System.out.println(n-hit);
        
}
}

