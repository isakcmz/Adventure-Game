import java.util.Scanner;

public class Player
{

    private int damage,healthy,money,realHealthy;
    private String name,characterName;
    private Inventory inv;

    Scanner scan = new Scanner(System.in);


    public Player(String name)
    {
        this.name = name;
        this.inv = new Inventory();
    }


    public void selectCha()
    {
        switch (chaMenu())
        {
            case 1:
                initPlayer("Samuray",5,21,15);
                break;

            case 2:
                initPlayer("Okçu",7,18,20);
                break;

            case 3:
                initPlayer("Şovalye",8,24,7);

                break;
        }

        System.out.println();
        System.out.println("Karakter: " + getCharacterName() + " \t Hasar: " + getDamage() + " \t Sağlık: " + getHealthy() + " \t Para: " + getMoney());
    }


    public void initPlayer(String cName, int dmg, int hlthy, int mny)
    {
        setCharacterName(cName);
        setDamage(dmg);
        setHealthy(hlthy);
        setMoney(mny);
        setRealHealthy(hlthy);
    }


    public int chaMenu()
    {
        System.out.println("1- Samuray  \t  Hasar:5  \t  Sağlık:21  \t  Para:15");
        System.out.println("2- Okçu     \t  Hasar:7  \t  Sağlık:18  \t  Para:20");
        System.out.println("3- Şovalye  \t  Hasar:8  \t  Sağlık:24  \t  Para:5");
        System.out.print("Karakter Seçiniz: ");
        int chaID = scan.nextInt();

        while(chaID<1 || chaID>3)
        {
            System.out.print("Lütfen Geçerli Bir Karakter Seçiniz: ");
            chaID = scan.nextInt();
        }

        return chaID;
    }

    public int getTotalDamage()
    {
        return this.getDamage() + this.getInv().getWeaponDamage();
    }





    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getRealHealthy() {
        return realHealthy;
    }

    public void setRealHealthy(int realHealthy) {
        this.realHealthy = realHealthy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
}
