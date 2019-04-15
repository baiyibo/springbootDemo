package shejimoshi.OB;

public interface Observer {
    void addObUser(ObUser obUser);
    void removeObUser(ObUser obUser);
    void notifyObUser();
}
