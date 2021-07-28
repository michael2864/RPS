import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class RPS {
    //    Написать консольную игру камень ножницы бумага
//    пользователь должен выбирать количество игр и ввести свое имя
//    пользователь должен иметь возможность прервать игру
//    после прекращения игры пользователь должен увидеть результат


/*
    Для игры КНБ добавить возможность сохранять результаты игры и ход игры в файлы
            (если файла нет создать его, если файлы есть дозаписать).
    Файла создавать в директории где стартует игра
    append to file  /result/result.txt
 log/log/txt every new file = game + name
 лог и результат вывода в разных методах     jar file

    */
    void makeFile (String userName) throws IOException {
        String s = "./Results/" + userName + "/";
        new File("./Results/" + userName ).mkdir();

        String fileName = "log_" + userName.toLowerCase(Locale.ROOT) + "_" + new SimpleDateFormat("yyyyMMddHHmm").format(new Date()) + ".txt";

        File out = new File (s + fileName);
        if(!out.exists()){
            out.createNewFile();
        } else {
            String newName = out.getName().split("\\.")[0] + "_1." + out.getName().split("\\.")[1];
            System.out.println(newName);
            new File(newName).createNewFile();
        }
    }

    void writeFile (String s, String userName) {
        try (

             FileWriter fw = new FileWriter("./Results/" + userName + "/" + "log_" + userName.toLowerCase(Locale.ROOT) + "_" + new SimpleDateFormat("yyyyMMddHHmm").format(new Date()) + ".txt",true)) {
                fw.write(s);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) throws IOException {
        Properties property = new Properties();

        new File("./Results/").mkdir();
        Scanner sc = new Scanner (System.in);
        System.out.println(property.getProperty(name));
        String userName = sc.nextLine();
             RPS r = new RPS ();
             r.makeFile(userName);
             r.writeFile("name: " + userName + "\n" ,userName);


        System.out.println(property.getProperty(games));
        int games = sc.nextInt();
        int score=0;
        // Rock - paper - scissors       player
        String matrix [][] = {{"Draw","Win","Lose"}, // Rock
                {"Win","Draw","Win"},  // Paper
                {"Lose","Win","Draw"}};  // Scissors
        //Start
        for (int k =0;k<games;k++) {
            r.writeFile("game No. " + k + "\n",userName);
            System.out.println("Enter ( 000 to end this game ),  (\"Rock 0  papers 1  scissors 2\"):  ");
            for (int i = sc.nextInt(); i < i + 1; i = 0) {
                if (i!=000) {
                    r.writeFile("Yours " + i + "\n",userName);
                    for (int j = (int) (Math.random() * (3 - 1)); j < j + 1; j = 0) {
                        System.out.println(property.getProperty(opponentt) + j);
                        r.writeFile(property.getProperty(opponentt) + j + "\n",userName);
                        System.out.println("result: " + matrix[i][j]);
                        if (matrix[i][j].equals("Win") || matrix[i][j].equals("Draw")) {
                            score++;}
                        r.writeFile(property.getProperty(end)+ "\n\n",userName );
                        break;
                    }
                }
                else
                break;
            }
        }

        System.out.println( property.getProperty(res)+ userName +" = " + score);
        r.writeFile("End game \n\n" ,userName );
        r.writeFile(property.getProperty(sc) + score + "\n",userName );
    }}



