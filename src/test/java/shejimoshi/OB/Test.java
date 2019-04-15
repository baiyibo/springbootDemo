package shejimoshi.OB;

public class Test {
    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        ObUser userZhang = new User("ZhangSan");
        ObUser userLi = new User("LiSi");
        ObUser userWang = new User("WangWu");

        server.addObUser(userZhang);
        server.addObUser(userLi);
        server.addObUser(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObUser(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");

    }
}
