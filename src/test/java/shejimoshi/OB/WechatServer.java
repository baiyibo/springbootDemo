package shejimoshi.OB;

import java.util.ArrayList;
import java.util.List;

public class WechatServer implements Observer {
    public List<ObUser> list;
    public String message;


    public WechatServer() {
        list=new ArrayList<ObUser>();
    }

    @Override
    public void addObUser(ObUser obUser) {
        list.add(obUser);
    }

    @Override
    public void removeObUser(ObUser obUser) {
        if(!list.isEmpty())
        list.remove(obUser);
    }

    @Override
    public void notifyObUser() {
        for (ObUser o:list) {
            o.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObUser();
    }

}
