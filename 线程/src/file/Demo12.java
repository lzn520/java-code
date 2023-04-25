package file;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:文件操作案例:扫描指定目录，并找到名称中包含指定字符的所有普通文件（不包含目录），并且后续询问用户是否要删除该文件
 * 查找文件并删除
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class Demo12 {
    public static void main(String[] args) {
        //1.先输入要删除文件的目录,以及要删除的文件的名字
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件的目录: ");
        String fileDirName = scanner.next();
        System.out.println("请输入要删除的文件名: ");
        String toDeleteName = scanner.next();
        File fDir = new File(fileDirName);
        //看看输入的文件是不是目录
        if(!fDir.isDirectory()){
            //输入的文件不是目录
            System.out.println("输入的文件目录有误!");
            return;
        }else{
            //进行查找删除
            scanFile(fDir,toDeleteName);
        }
    }

    private static void scanFile(File fileDirName, String toDeleteName) {
        //.进行文件的删除,挨个遍历目录里面的文件
        File[] files = fileDirName.listFiles();
        if(files == null){
            //说明目录里面什么都没有
            return;
        }
        //2.遍历当前列出的这些内容,如果是普通文件,检测文件名是否是要删除的文件
        //如果是目录就递归遍历
        for (File f: files) {
            if(f.isDirectory()){
                //是目录就递归遍历
                scanFile(f,toDeleteName);
            }else if(f.isFile()){
                //不要求名字一模一样,只要包含关键字就删除
                if (f.getName().contains(toDeleteName)){
                    deleteFile(f);
                }
            }
        }
    }

    private static void deleteFile(File f) {

        try {
            Scanner scanner = new Scanner(System.in);
            //判断是不是真的要删除
            System.out.println(f.getCanonicalPath()+"确认要删除文件吗?(Y/N)");
            String choice = scanner.next();
            if(choice.equals("Y")|choice.equals("y")){
                //确认删除
                f.delete();
                System.out.println("删除成功");
            }else{
                System.out.println("文件取消删除");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
