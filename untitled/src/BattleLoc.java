public abstract class BattleLoc extends Location
{

    protected Obstacle obstacle;
    protected String award;

    BattleLoc(Player player, String name, Obstacle obstacle, String award)
    {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;
    }


    public boolean getLocation()
    {
        int obsCount = obstacle.obstacleCount();
        System.out.println("Şuan " + this.getName() + " Adlı Yerdesiniz. ");
        System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor.");
        System.out.print("<S>avaş  veya   <K>aç  :  ");
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();

        if(selCase.equals("S"))
        {
            if (combat(obsCount))
            {
                System.out.println(this.getName() + " Bölgesindeki Tüm Düşmanları Temizlediniz !");

                if(this.award.equals("Food") && player.getInv().isFood() == false)
                {
                    System.out.println(this.award + " Kazandınız !");
                    player.getInv().setFood(true);
                }
                else if (this.award.equals("Water") && player.getInv().isWater() == false)
                {
                    System.out.println(this.award + " Kazandınız !");
                    player.getInv().setWater(true);
                }
                else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false)
                {
                    System.out.println(this.award + " Kazandınız !");
                    player.getInv().setFirewood(true);
                }

                return true;
            }

            if(player.getHealthy() <= 0)
            {
                System.out.println("ÖLDÜNÜZ...");
                return false;
            }
        }

        return true;
    }


    public boolean combat(int obsCount)
    {
        for(int i=0; i<obsCount; i++)
        {
            int defObsHealthy = obstacle.getHealthy();      // Döngü 1 kez çalıştıktan sonra diğer canavarın canını yeniledik.

            playerStats();
            enemyStats();
            while(player.getHealthy() > 0   &&  obstacle.getHealthy() > 0)
            {
                System.out.print("<V>ur  veya  <K>aç  :  ");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();

                if(selCase.equals("V"))
                {
                    System.out.println("Siz Vurdunuz !");
                    obstacle.setHealthy(obstacle.getHealthy() - player.getTotalDamage());
                    afterHit();
                    if(obstacle.getHealthy() > 0) {
                        System.out.println(obstacle.getName() + " size vurdu !");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmorAvoid()));
                        afterHit();
                    }
                }

                else
                {
                    return false;
                }

            }

            if (obstacle.getHealthy() < player.getHealthy())
            {
                System.out.println((i+1) + ". Düşmanı Yendiniz.");

                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Güncel Paranız: " + player.getMoney());
                obstacle.setHealthy(defObsHealthy);

            }

            else       return false;

            System.out.println("-----------------------");

        }
        return true;
    }


    public void playerStats()
    {
        System.out.println("\nOyuncu Değerleri\n----------");
        System.out.println("Can: " + player.getHealthy());
        System.out.println("Hasar: " + player.getTotalDamage());
        System.out.println("Para: " + player.getMoney());

        if(player.getInv().getWeaponDamage() > 0)
        {
            System.out.println("Silah: " + player.getInv().getWeaponName());
        }
        if(player.getInv().getArmorAvoid() > 0 )
        {
            System.out.println("Zırh: " + player.getInv().getArmorName());
        }
        System.out.println();
    }

    public void enemyStats()
    {
        System.out.println(obstacle.getName() + " Değerleri\n----------");
        System.out.println("Can: " + obstacle.getHealthy());
        System.out.println("Hasar: " + obstacle.getDamage());
        System.out.println("Ödül: " + obstacle.getAward());
        System.out.println();
    }

    public void afterHit()
    {
        System.out.println("Oyuncu Canı: " + player.getHealthy());
        System.out.println(obstacle.getName() + " Canı: " + obstacle.getHealthy());
        System.out.println();
    }


}
