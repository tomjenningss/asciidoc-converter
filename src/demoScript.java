import java.io.*;



public class demoScript{
	

		public static void main(String[] args)throws Exception 
		{
			
			String exampleArg = "Example argument to pass in: 2020-01-17-openshift-oauth-server-social-login-liberty-20001.html";
			String newLine = "\n";
			
			if(args.length!=1) 
			{
				System.out.println(newLine + "Wrong amount of arguments passed to Java program");
				System.out.println(exampleArg);
				System.out.println("Please try again");
			}
		
			try {
                  String text = "";
		          int lineNumber;
                  FileReader readfile = new FileReader(args[0]);
                  String removeText = args[0].substring(0, args[0].length() - 4);
                  String renderedFile = removeText + "html";
                  
		          BufferedReader readbuffer = new BufferedReader(readfile);
		          BufferedWriter writer = new BufferedWriter(new FileWriter("rendered-"+renderedFile));
		          for (lineNumber = 1; lineNumber < 447; lineNumber++) 
		          {
		            if (lineNumber == 454) 
		            {
		              text = readbuffer.readLine();
		            } 
		            else
		            readbuffer.readLine();
		          }
		          
		          while (text != null) 
		          {
		        	  	//Array of objects to replace with null
                        String[] replaceObject = {"<p>","</p>","</div>","<div class=\"sectionbody\">","<div class=\"paragraph\">",
                        "<div class=\"listingblock\">", "<div class=\"content\">","<div id=\"footer\">","<div id=\"footer-text\">",
                        "<div class=\"sect1\">","<div class=\"ulist\">","</body>","</html>"};
                       
                        for (int i = 0; i < replaceObject.length; i++){
                            text = text.replace(replaceObject[i], "");
                        }
                       
						//Tag Replacement
						text = text.replace("&lt;", "<");
						text = text.replace("&gt;", ">");
						
						//Apostrophe replacement 
						text = text.replace("&#8217;", "'");
						
						//Language replacement - xml, gradle
						text = text.replace("<pre class=\"highlight\"><code>FROM open-liberty</code></pre>", "[code lang=\"text\"]" + "\n" 
						+ "FROM open-liberty" + "[/code]");
						
						
						text = text.replace("<pre class=\"highlight\"><code class=\"language-xml\" data-lang=\"xml\">", "[code lang=" + "\"xml\"]" + "\n");
						text = text.replace("<pre class=\"highlight\"><code class=\"language-gradle\" data-lang=\"gradle\">", "[code lang=" + "\"gradle\"] \n");
						text = text.replace("</code></pre>", "[/code]");
						text = text.replace("</server>[/code]", "</server>" + "\n" + "[/code]");
						text = text.replace("[/code]", "\n" + "[/code]");
						
						//URL-prefix replacement
						text = text.replace("{url-prefix}", "https://openliberty.io/");
						text = text.replace("{url-about}", "https://openliberty.io/about");

						//System.out.println(text);
						writer.write(text);
						writer.write("\n");
						
						text = readbuffer.readLine();
					}
					readbuffer.close();
					writer.close();
		        } 
		        catch (IOException e) 
		        {
		        	System.out.println(newLine + "File Not Found");
		        	e.printStackTrace();
		        	System.out.println(exampleArg + newLine);
		        }
			
			catch (Exception e) 
			{
				System.out.println(e + newLine);
				
			}
		
		}
}