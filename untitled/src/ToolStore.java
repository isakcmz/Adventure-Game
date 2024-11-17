import java.util.Scanner;

public class ToolStore extends NormalLoc
{

    ToolStore(Player player)
    {
        super(player, "Mağaza");
    }


    public boolean getLocation() {
        System.out.println("1. Silahlar");
        System.out.println("2. Zırhlar");
        System.out.println("3. Çıkış...");
        System.out.print("Seçiminiz: ");
        int selTool = scan.nextInt();
        int selItemID;

        switch(selTool)
        {
            case 1:
                selItemID = weponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            case 3:
                System.out.println("Çıkış Yapıldı !");
                break;
            default:
                break;
        }

        return true;
    }



    public int weponMenu()
    {
        System.out.println("                                            Para: " + player.getMoney());
        System.out.println("1. Tabanca \t Para:25 \t Hasar:2");
        System.out.println("2. Kılç    \t Para:35 \t Hasar:3");
        System.out.println("3. Tüfek   \t Para:45 \t Hasar:7");
        System.out.println("4. Çıkış...");
        System.out.print("Silah Seçiniz: ");
        int selWeaponID = scan.nextInt();
        return selWeaponID;
    }

    public void buyWeapon(int itemID)
    {

        int wDamage = 0, weaponPrice = 0;
        String weaponNmae = null;

        switch(itemID)
        {
            case 1:
                wDamage = 2;
                weaponPrice = 25;
                weaponNmae = "Tabanca";
                break;
            case 2:
                wDamage = 3;
                weaponPrice = 35;
                weaponNmae = "Kılıç";
                break;
            case 3:
                wDamage = 7;
                weaponPrice = 45;
                weaponNmae = "Tüfek";
                break;
            case 4:
                System.out.println("Çıkış Yapıldı !");
                break;
            default:
                System.out.println("Geçersiz İşlem !");
                break;
        }


        if (weaponPrice > 0)
        {
            if (player.getMoney() >= weaponPrice) {
                player.getInv().setWeaponDamage(wDamage);
                player.getInv().setWeaponName(weaponNmae);
                player.setMoney(player.getMoney() - weaponPrice);

                System.out.println(weaponNmae + " Satın Aldınız.     Önceki Hasar: " + player.getDamage() + "     Yeni Hasar: " + player.getTotalDamage());
                System.out.println("Kalan Para: " + player.getMoney());

            }

            else       System.out.println("Bakiye Yetersiz !");
        }
    }




    public int armorMenu()
    {
        System.out.println("                                            Para: " + player.getMoney());
        System.out.println("1. Hafif  \t Para:15 \t Engelleme:1");
        System.out.println("2. Orta   \t Para:25 \t Engelleme:3");
        System.out.println("3. Ağır   \t Para:40 \t Engelleme:5");
        System.out.println("4. Çıkış...");
        System.out.print("Zırh Seçiniz: ");
        int selArmorID = scan.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID)
    {
        int aAvoid = 0, armorPrice = 0;
        String armorName = null;

        switch(itemID)
        {
            case 1:
                aAvoid = 1;
                armorPrice = 15;
                armorName = "Hafif Zırh";
                break;
            case 2:
                aAvoid = 3;
                armorPrice = 25;
                armorName = "Orta Zırh";
                break;
            case 3:
                aAvoid = 5;
                armorPrice = 40;
                armorName = "Ağır Zırh";
                break;
            case 4:
                System.out.println("Çıkış Yapıldı !");
                break;
            default:
                System.out.println("Geçersiz İşlem !");
                break;
        }


        if (armorPrice > 0)
        {
            if (player.getMoney() >= armorPrice)
            {
                player.getInv().setArmorAvoid(aAvoid);
                player.getInv().setArmorName(armorName);
                player.setMoney(player.getMoney() - armorPrice);

                System.out.println(armorName + " Satın Aldınız.     Engellenen Hasar: " + player.getInv().getArmorAvoid());
                System.out.println("Kalan Para: " + player.getMoney());
            }

            else       System.out.println("Bakiye Yetersiz !");
        }

    }

}
