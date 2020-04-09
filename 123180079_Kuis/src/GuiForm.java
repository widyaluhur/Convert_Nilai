import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuiForm extends JFrame {
    JLabel lnim, lnama, lmatkul1, lnilai1, lmatkul2, lnilai2;
    JTextField tfnim, tfnama, tfmatkul1, tfnilai1, tfmatkul2, tfnilai2;
    JButton done, clear;
    
    public void form(){
        // Membuat judul pada frame
        setTitle("Hitung Nilai");
        // Inisialisasi masing masing komponen
        lnim = new JLabel("NIM");
        lnama = new JLabel("Nama");
        lmatkul1 = new JLabel("Mata Kuliah 1");
        lnilai1 = new JLabel("Nilai 1");
        lmatkul2 = new JLabel("Mata Kuliah 2");
        lnilai2 = new JLabel("Nilai 2");
         
        tfnim = new JTextField("");
        tfnama = new JTextField("");
        tfmatkul1 = new JTextField("");
        tfnilai1 = new JTextField("");
        tfmatkul2 = new JTextField("");
        tfnilai2 = new JTextField("");
        
        done = new JButton("Convert");
        clear = new JButton("Clear");
        // Menambahkan masing masing komponen kedalam frame
        setLayout(null);
        add(lnim);
        add(lnama);
        add(lmatkul1);
        add(lnilai1);
        add(lmatkul2);
        add(lnilai2);
        add(tfnim);
        add(tfnama);
        add(tfmatkul1);
        add(tfnilai1);
        add(tfmatkul2);
        add(tfnilai2);
        add(done);
        add(clear);
        // Mengatur tata letak setiap komponen
        lnim.setBounds(30, 20, 40, 25);
        tfnim.setBounds(130, 20, 150, 25);
        lnama.setBounds(30, 55, 40, 25);
        tfnama.setBounds(130,55, 230, 25);
        lmatkul1.setBounds(30, 90, 100, 25);
        tfmatkul1.setBounds(130, 90, 230, 25);
        lnilai1.setBounds(30, 125, 100, 25);
        tfnilai1.setBounds(130, 125, 80, 25);
        lmatkul2.setBounds(30, 160, 100, 25);
        tfmatkul2.setBounds(130, 160, 230, 25);
        lnilai2.setBounds(30, 195, 100, 25);
        tfnilai2.setBounds(130, 195, 80, 25);
        done.setBounds(130, 240, 100, 25);
        clear.setBounds(250, 240, 100, 25);
        
        setSize(420,350); //luas tampilan
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Melakukan convert
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ex) {
                try{
                    Convert calculate = new Convert();
                    
                    String nim, nama, matkul1, matkul2, grade;
                    float nilai1, nilai2, rata;
                    nim =  tfnim.getText();
                    nama = tfnama.getText();
                    matkul1 = tfmatkul1.getText();
                    nilai1 =  Float.parseFloat(tfnilai1.getText());
                    matkul2 = tfmatkul2.getText();
                    nilai2 =  Float.parseFloat(tfnilai2.getText());
                    //Melakukan test nilai, melempar nilai ke testing
                    testing(nim, nama, matkul1, nilai1, matkul2, nilai2);
                    //Melakukan perhitung rata - rata, melempar nilai ke Convert/hasil
                    rata = calculate.hasil(nilai1, nilai2);
                
                    System.out.println("NIM\t\t: "+nim);
                    System.out.println("Nama\t\t: "+nama);
                    System.out.println("Mata Kuliah 1\t: "+matkul1);
                    System.out.println("Mata Kuliah 2\t: "+matkul2);
                    System.out.println("Rata - rata\t: "+rata);
                    //Mengambil data nilai huruf dari Convert/hitung
                    System.out.println("Nilai  Huruf\t: "+calculate.hitung(rata));
                
                }catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane,"Tipe Data Salah");
                }catch(Error ext) {
                    JOptionPane.showMessageDialog(rootPane,ext);
                } 
            }
        });
         
        //Membersihkan(mereset) nilai form pada textbox
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ep) {
                tfnim.setText("");
                tfnama.setText("");
                tfmatkul1.setText("");
                tfmatkul2.setText("");
                tfnilai1.setText("");
                tfnilai2.setText("");
            }
        });
    }
    
    //Melakukan test nilai
    public void testing(String nim, String nama, String matkul1, float nilai1, String matkul2, float nilai2) throws Error{
        //Tes data masukkan, seluruh data input harus terisi
        if (!(nim.length() > 0 && nama.length() > 0 && matkul1.length() > 0 && (Float.toString(nilai1)).length() > 0 && matkul2.length() > 0 && (Float.toString(nilai2)).length() > 0)){
            throw new Error("Input masih kosong");
        }
        //Tes input nilai sesuai batasan nilai angka
        else if (!(nilai1 >= 0 && nilai1 <= 100 && nilai2 >= 0 && nilai2 <= 100)) {
            throw new Error("Masukan data nilai antara ( 1 - 100 )");
        }
    }
}