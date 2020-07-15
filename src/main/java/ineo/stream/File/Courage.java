package ineo.stream.File;

import org.apache.http.util.TextUtils;

import java.io.*;

public class Courage {
    /**
     * 创建一个文件夹吧
     */
    public void createFolder(String path) {
        try {
            String folderPath = path;
            if (TextUtils.isEmpty(folderPath)) {
                throw new Exception("文件夹路径有误，请检查传入的参数是否有误！");
            }
            File folder = new File(folderPath);
            if (!folder.exists()) {
                //待会比较一下这两方法
                /*
                这个，因为我目前的目录不完整。没有CreateFolder，所以后面的1和2建不出来
                 */
                //folder.mkdir();
                /*
                但我这样可以
                 */
                folder.mkdirs();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件
     * @param filePath 文件路径
     * @param fileContent 文件内容
     * @throws Exception 异常
     */
    public void createFile(String filePath,String fileContent) throws Exception{
        try {
            if (TextUtils.isEmpty(filePath)) {
                throw new Exception("所给参数文件名称不正确，请检查！");
            }
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            //这样写入不会保持格式，我们来包装一下。
            //fileWriter.write(fileContent);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(fileContent);
            printWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("创建文件出错！");
        }
    }

    /**
     * 删除文件
     * @param filePath
     * @throws Exception
     */
    public void deleteFile(String filePath) throws Exception{
        try {
            if (TextUtils.isEmpty(filePath)) {
                throw new Exception("参数有误，文件路径为空。请检查参数！");
            }
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("删除文件出错");
        }
    }

    public void deleteFolder(String path) {

        try {
            if (null == path || "".equals(path)) {
                System.out.println("文件路径解析错误，请检查传入的参数是否有误！");
                return;
            }
            File file = new File(path);
            String[] list = file.list();
            if (list.length > 0) {
                deleteAllFiles(path);
            }
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteAllFiles(String filePath) {
        try {
            if (null == filePath || "".equals(filePath)) {
                System.out.println("从参数中获取文件路径错误，请检查参数！");
                return;
            }
            File file = new File(filePath);
            if (!file.exists()) {
                return;
            }
            if (!file.isDirectory()) {
                return;
            }
            //获取该路径下的全部文件
            String[] list = file.list();
            File tempFile = null;
            for (int i = 0; i < list.length; i++) {
                if (filePath.endsWith(file.separator)) {
                    tempFile = new File(filePath + list[i]);
                } else {
                    tempFile = new File(filePath + tempFile.separator + list[i]);
                }
                if (tempFile.isDirectory()) {
                    deleteAllFiles(filePath+file.separator+list[i]);
                    deleteFolder(filePath+file.separator+list[i]);
                }
                if (tempFile.isFile()) {
                    tempFile.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void copyFile(String originFilePath,String targetFilePath) {
        try {
            if (null == originFilePath || "".equals(originFilePath)) {
                throw new Exception("源文件路径解析错误，请检查参数是否有误！");
            }
            if (null == targetFilePath || "".equals(targetFilePath)) {
                throw new Exception("目标文件路径解析错误，请检查参数是否有误！");
            }
            File file = new File(originFilePath);
            if (!file.exists()) {
                throw new Exception("源文件不存在！");
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(targetFilePath);
            /*int temp = 0;
            while ((temp = fileInputStream.read()) != -1) {
                fileOutputStream.write(temp);
            }*/
            int len = 0;
            byte[] arr = new byte[1024];
            while ((len = fileInputStream.read(arr)) != -1) {
                fileOutputStream.write(arr,0,len);
                //这个回去测试一下
            }
            //
            fileOutputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void copyFolder(String originFolder,String targetFolder) {
        try {
            if (null == originFolder || "".equals(originFolder)) {
                throw new Exception("源文件路径解析错误，请检查参数是否有误！");
            }
            if (null == targetFolder || "".equals(targetFolder)) {
                throw new Exception("目标文件路径解析错误，请检查参数是否有误！");
            }
            (new File(targetFolder)).mkdirs();//如果文件夹不存在 则建立新文件夹

            File file = new File(originFolder);
            String[] list = file.list();
            File tempFile = null;
            for (int i = 0; i < list.length; i++) {
                if (originFolder.endsWith(file.separator)) {
                    tempFile = new File(originFolder + list[i]);
                } else {
                    tempFile = new File(originFolder + tempFile.separator + list[i]);
                }
                if (tempFile.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(tempFile);
                    //这儿在做的时候写错了哦。要注意。new FileOutputStream(targetFolder+tempFile.separator + list[i]);
                    FileOutputStream fileOutputStream = new FileOutputStream(targetFolder+tempFile.separator + list[i]);
                    int len = 0;
                    byte[] arr = new byte[1024];
                    while ((len = fileInputStream.read()) != -1) {
                        fileOutputStream.write(arr,0,len);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileInputStream.close();
                }
                if (tempFile.isDirectory()) {
                    copyFolder(originFolder+tempFile.separator+tempFile.getName(),targetFolder+tempFile.separator+tempFile.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("复制文件夹出错！");
        }

    }

    public static void main(String[] args) throws Exception {
        Courage courage = new Courage();
        String path = "C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\CreateFolder\\1\\2\\1.txt";
        //courage.createFolder("C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\CreateFolder\\1\\2");
        courage.createFile(path,"我爱你中国");
        //courage.deleteFolder(path.substring(0,path.lastIndexOf("\\")));
        //courage.deleteFile(path);

        String str1 = "C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\Someone_Like_You.md";
        String str2 = "C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\File_someone_like_you.txt";
        //courage.copyFile(str1,str2);

        String str3 = "C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\CreateFolder\\1";
        String str4 = "C:\\Users\\niu\\Desktop\\Java\\我的工作空间\\CreateFolder\\copyFolder";
        courage.copyFolder(str3,str4);

    }
}
