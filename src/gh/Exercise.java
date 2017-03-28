package gh;


import java.io.*;


/**
 * TODO
 * 1. Get familiar with Git commands through the UI
 * 2. GOAL : The overall goal of the technical exercise will be to write a script to analyze the output of git commands.
 *          To prepare, we'd like you create a simple script in the language you're most comfortable using for string parsing
 *          and data manipulation. We'll use this script as a starting point for the exercise.
 */
public class Exercise {

  public static String folder = "/Users/mahesh.subramanian/git/GitHub/jquery-pjax";

  /**
   * Execute branch as a sub-process in my local clone of jquery-pjax repository and prints the command's output.
   */
  public int branch() throws IOException {
    int exitValue = Integer.MIN_VALUE;

    BufferedReader in = null;
    InputStreamReader is = null;

    try {

      File file = new File(folder);
      String [] envp = null;
      Process p = Runtime.getRuntime().exec("git branch -a", envp, file);
      // Process p = Runtime.getRuntime().exec("ls -l ", envp, file);

      exitValue = p.waitFor();

      String line;
      // Alternatively write to file
      System.setOut(new PrintStream(new FileOutputStream(folder + "/out.txt")));
      is = new InputStreamReader(p.getInputStream());
      in = new BufferedReader(is);
      while ((line = in.readLine()) != null) {
        log(line);
      }
      // Reset to system.out
      System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    } catch (IOException e) {
      log(e.getMessage());
    } catch (InterruptedException e) {
      log(e.getMessage());
    } finally {
      if (is != null) is.close();
      if (in != null) in.close();
    }
    return exitValue;
  }

  /**
   * Traverse sub folders and print the contents of each folder
   * @return
   */
  public void traverseSubFolders(String path, int depth) {
    File root = new File(path);
    File [] files = root.listFiles();
    if (files == null) return;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <  depth; i++) sb.append(' ');

    for (File f : files) {
      if (f.isDirectory()) {
        traverseSubFolders(f.getAbsolutePath(), depth++);
      } else {
        log(sb.toString() + f.getAbsoluteFile().getName());
      }
    }
  }

  /**
   * Utility method to print to console
   * @param s
   */
  public void log(String s) {
    System.out.println(s);
  }

  /**
   * Reada file and print output to console
   * @param fileName
   */
  public void readFile(String fileName) {
    BufferedReader bufferedReader = null;
    FileReader fileReader = null;
    try {
      File f = new File(fileName);
      fileReader = new FileReader(f);
      bufferedReader = new BufferedReader(fileReader);
      String readLine = "";
      while ((readLine = bufferedReader.readLine()) != null) {
        log(readLine);
      }
    } catch (IOException e) {
      log(e.getMessage());
    } finally {
      if (bufferedReader != null) {
        try {
          if (fileReader != null) fileReader.close();
          if (bufferedReader != null) bufferedReader.close();
        } catch (IOException e) {
          log(e.getMessage());
        }
      }
    }

  }

  public static void main(String[] args) {
    Exercise ex = new Exercise();
    int val = 0;
    try {
      val = ex.branch();
    } catch (IOException e) {
      ex.log(e.getMessage());
    }
    ex.log("Exit value : " + val);
    // Print file to console
    ex.readFile(folder + "/out.txt");
/*
    // Walk list of folders
    ex.log("");
    ex.log("Traversing subfolders starting from:" + folder);
    ex.traverseSubFolders(folder, 0);
*/
  }

}