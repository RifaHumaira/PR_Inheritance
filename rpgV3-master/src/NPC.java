import java.util.ArrayList;

public class NPC extends Player{
    //kunci dipindahkan dari ruangan
//    private Item  objKunci;
    private ArrayList<String> arrAksi = new ArrayList<>();
    //    private GameInfo objGameInfo;
    private boolean isKenal = false;

    public NPC() {
        nama = "Ken";
        //init kunci
        objItem = new Item("Kunci");
        objItem.setDeskripsi("Sebuah kunci kecil yang sudah agak berkarat");

        //aksi npc
        arrAksi.add("Perkenalan dgn NPC");
        arrAksi.add("Minta kunci");
    }

    public void prosesAksi(int subPil) {
        //1: perkenalan dengan npc
        //2: buka pintu
        if (subPil == 1) {
            if (isKenal==false){
                System.out.printf("Halo saya %s penjaga pintu ini",nama);
                isKenal = true;
            }else{
                System.out.println("Saya memiliki Kunci");
            }
        } else if (subPil == 2) {
            if (isKenal) {
                //berikan kunci pada player
                if (objItem==null) {
                    System.out.println("Masa lupa, kunci kan sudah saya berikan!");
                } else
                {
                    System.out.println("Kunci diberikan pada player");
                    objGameInfo.getObjPlayer().addItem(objItem);     //tambahkan  objek ini pada player
                    objItem = null;
                }

            } else {
                System.out.println("Siapa anda? kenalan dulu dong");
            }
        }
    }

    public ArrayList<String> getAksi() {
        return arrAksi;
    }
}
