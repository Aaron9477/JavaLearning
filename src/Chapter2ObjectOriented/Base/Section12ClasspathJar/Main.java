package Chapter2ObjectOriented.Base.Section12ClasspathJar;

// jar包: 如果有很多.class文件，散落在各层目录中，肯定不便于管理。如果能把目录打一个包，变成一个文件，就方便多了。
// jar包就是用来干这个事的，它可以把package组织的目录层级，以及各个目录下的所有文件（包括.class文件和其他文件）都打成一个jar文件 => 这样一来，无论是备份，还是发给客户，就简单多了。
// jar包实际上就是一个zip格式的压缩文件，而jar包相当于目录。如果我们要执行一个jar包的class，就可以把jar包放到classpath中

// 制造jar包
// 找到正确的目录，点击右键，在弹出的快捷菜单中选择“发送到”，“压缩(zipped)文件夹”
// 就制作了一个zip文件。然后，把后缀从.zip改为.jar，一个jar包就创建成功。
public class Main {
}
