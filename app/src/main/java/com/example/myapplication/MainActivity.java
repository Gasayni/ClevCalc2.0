package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener{

    public String SaveTextString;
    Button btn_drob;
    Button btn_currency;


    @Override // Скрипт для Меню
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // switch обработка нажатия кнопок МЕНЮ
        switch (id) {
            case R.id.Support_settings:
                Toast.makeText(MainActivity.this, "Спасибо!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Apps_settings:
                Toast.makeText(MainActivity.this, "В моем телеграм-канале", Toast.LENGTH_SHORT).show();
                break;
            case R.id.TellAbout_settings:
                Toast.makeText(MainActivity.this, "Спасибо, что рассказали о нас!", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myscreen);
        btn_drob = findViewById(R.id.btnDrob);
        btn_drob.setOnClickListener(this);
        btn_currency = findViewById(R.id.currency);
        btn_currency.setOnClickListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        int leftValue = i;
        int rightValue = seekBar.getMax() - i;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    public void onButtonClickPlus(View v) {

        EditText resText = findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (!OldTextString.equals("")) {
            if (s[s.length - 1].equals("(")
                    || s[s.length - 1].equals(".")
                    || s[s.length - 1].equals("*")
                    || s[s.length - 1].equals("/")
                    || s[s.length - 1].equals("+")
                    || s[s.length - 1].equals("-")
                    || s[s.length - 1].equals("%")
                    || s[s.length - 1].equals("^")) {
                // если раньше были знаки то еще раз знак писать не нужно писать
            } else {
                resText.setText(OldTextString + "+");
            }
        }
    } //+
    public void onButtonClickBracket(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String

        String[] s = OldTextString.split("");
        int openBracketCount = 0, closeBracketCount = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("(")) {
                openBracketCount += 1;
            } else if (s[i].equals(")")) {
                closeBracketCount += 1;
            }
        }
        // если открытых скобок больше чем закрытых и
        // если предыдущая стояла '(' и
        // если предыдущий был не знак
        if (openBracketCount > closeBracketCount) {
            if (s[s.length - 1].equals("(")
                    || s[s.length - 1].equals("*")
                    || s[s.length - 1].equals("/")
                    || s[s.length - 1].equals("+")
                    || s[s.length - 1].equals("-")
                    || s[s.length - 1].equals("^")) {
                resText.setText(OldTextString + "(");
            } else if (s[s.length - 1].equals(".")) {
                // если раньше были знаки то закрывающая скобка не нужна
            } else{
                resText.setText(OldTextString + ")");
            }
        }

        else {
            if (OldTextString.equals("")
                    || s[s.length - 1].equals("*")
                    || s[s.length - 1].equals("/")
                    || s[s.length - 1].equals("+")
                    || s[s.length - 1].equals("-")
                    || s[s.length - 1].equals("^")) {
                resText.setText(OldTextString + "(");
            } else resText.setText(OldTextString + "*" + "(");
        }
    } //+
    public void onButtonClickDel(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (!OldTextString.equals("")) {
            if (s[s.length - 1].equals("(")
                    || s[s.length - 1].equals(".")
                    || s[s.length - 1].equals("*")
                    || s[s.length - 1].equals("/")
                    || s[s.length - 1].equals("+")
                    || s[s.length - 1].equals("-")
                    || s[s.length - 1].equals("%")
                    || s[s.length - 1].equals("^")) {
                // если раньше были знаки то еще раз знак писать не нужно писать
            } else {
                resText.setText(OldTextString + "/");
            }
        }
    } //+
    public void onButtonClickTimes(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (!OldTextString.equals("")) {
            if (s[s.length - 1].equals("(")
                    || s[s.length - 1].equals(".")
                    || s[s.length - 1].equals("*")
                    || s[s.length - 1].equals("/")
                    || s[s.length - 1].equals("+")
                    || s[s.length - 1].equals("-")
                    || s[s.length - 1].equals("%")
                    || s[s.length - 1].equals("^")) {
                // если раньше были знаки то еще раз знак писать не нужно писать
            } else {
                resText.setText(OldTextString + "*");
            }
        }
    } //
    public void onButtonClickMinus(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (s[s.length - 1].equals("*")
                || s[s.length - 1].equals("/")
                || s[s.length - 1].equals("+")
                || s[s.length - 1].equals("%")
                || s[s.length - 1].equals("-")
                || s[s.length - 1].equals("^")) {
            resText.setText(OldTextString + "(" + "-");

        } else if (s[s.length - 1].equals(".")) {
            // если раньше были знаки то еще раз знак писать не нужно
        } else resText.setText(OldTextString + "-");
    } //+
    public void onButtonClickExp(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        resText.setText(OldTextString + "^"); // тут все в String формате
    }
    public void onButtonClickStill(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String


        //Все херня. Сделаю проще. У нас есть невъебический пример, с можеством скобок, внутри этих скобок еще скобки,
        // внутри этих скобок много разных операций с разными уровнями приоритетности и т.п.
        // Сделаю намного проще.
        // 0. Заносим нашу строку с пимером тупо посимвольно в Дмассив, который будет каждый раз обновляться
        // 1. Берем это уравнение и находим там первую закрытую скобку там же можем найти ее открытую скобку
        // 2. В этих скобках находим первую операцию умножения или деления и решаем ее
        // 3. ее решение мы записываем в Дмассив, который всегда обновляется

        String[] s = OldTextString.split(""); //разделили посимвольно
        // проверяем количество открытых и закрытых скобок
        int openBracketCount = 0, closeBracketCount = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("(")) {
                openBracketCount += 1;
            } else if (s[i].equals(")")) {
                closeBracketCount += 1;
            }
        }
        int countBracket = openBracketCount - closeBracketCount;
        // если открытых скобок больше чем закрытых
        // то добавляем недостающие скобки
        if (openBracketCount > closeBracketCount){
//            resText.setText(OldTextString + "   не хватает ")"");
//            for (int i = 0; i < countBracket; i++)
            resText.setText(OldTextString + ")");
            openBracketCount++;

        } else {
            Boolean act = true; //Проверка на знак '=' уже стоит или нет
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("=")) {
                    act = false;
                    //то мы ничего не делаем
                }
            }
            if (OldTextString.equals("")) {
            } else if (!act) { // если '=' уже стоит или открывающих скобок больше, то мы ничего не делаем, иначе ->
                resText.setText(OldTextString + "   знак '=' уже стоит");
            } else {
                ArrayList<String> num = new ArrayList<>(); // создали Дмассив для чисел.

                //ЕСЛИ первым элементом сразу стоит '-'. (для Пр: -5+2) (ч.3 из 4)
                if (s[1].equals("-")) {
                    num.add(s[1] + s[2]);
                }

                String cut = "";
                for (int i = 0; i < s.length; i++) {
                    //ЕСЛИ первый элемент пустой ""
                    if (s[i].equals("")) {
                        // то мы должны его пропустить, никуда не записывать и ничто не увеличивать
                    } else if (s[i].equals(")")
                            || s[i].equals("+")
                            || s[i].equals("-")
                            || s[i].equals("*")
                            || s[i].equals("^")
                            || s[i].equals("/")
                            || s[i].equals("(")
                            || s[i].equals("%")) {

                        //ЕСЛИ после скобок сразу стоит '-'
                        // то, мы должны это число целиком закинуть в ячейку массива
                        if ((i != 0 && s[i - 1].equals("(") && s[i].equals("-"))) {
                            num.add(s[i] + s[i + 1]);
                        }
                        // ЕСЛИ это 1-ой элемент и это '-'. (для Пр: -5+2) (ч.2 из 4)
                        if (i == 1 && s[i].equals("-")) {
                            //то мы не должны ни суммировать, ни записывать. Мы уже это сделали выше, до цикла.
                        }
                        // ЕСЛИ Дмассив не пустой и ПУСТОЙ заполнитель  (для Пр: -5+2) (ч.3 из 4)
                        else if (num.size() != 0 && cut.equals("") && !s[i].equals("-")) {
                            num.add(s[i]);
                        } else if (!cut.equals("")) { // добавляется только в случае не пустого заполнителя
                            num.add(cut); // мы записывам накопившееся число в num в виде строки
                            num.add(s[i]);
                            cut = "";
                        }
                    } else if (s[i - 1].equals("-") && (i == 2 || s[i - 2].equals("("))) {
                        // ЕСЛИ это 2-ой элемент и первым элементом был '-'. (для Пр: -5+2) (ч.4 из 4)
                    } else
                        cut += s[i]; // заполняем число цифрами, пока не встретится математический знак

                } // записали числа и знаки в соответствующие массивы с сохранением порядка
                if (!cut.equals("")) {
                    num.add(cut); // мы записывам последнее число в num в виде строки
                }

//                System.out.println("1. num.size()= " + num.size());
//                System.out.println("Изночально num:");
                for (int k = 0; k < num.size(); k++) {
                    System.out.print(num.get(k) + "");
                }
                System.out.println();
                System.out.println(); // Проверка на прочность


                // будем циклиться пока в нашем Дмассиве не останется только одно число с ответом, его мы и выведем
                while (num.size() > 1) {
                    int indifCloseBracket = 0, indifOpenBracket = 0; // забиваем место для позиции открытой и закрытой скобки


                    //                   Идем по Дмассиву в поисках первой закрытой скобки
                    Boolean ContainBrackets = false;
                    for (int i = 0; i < num.size(); i++) {
                        //     ЕСЛИ СКОБКИ ЕСТЬ       то нужно тупо решить пример внутри скобки
                        if (num.get(i).equals(")")) {
                            ContainBrackets = true;
//                    System.out.println("Мы нашли первую закрывающую скобку, ура, она находится в позиции: " + i);
                            // Идем теперь обратно по массиву в поисках ее открывающей скобки
                            for (int j = i - 1; j > 0; j--) {
                                // когда находим открывающую, мы можем работать с примером внутри скобки
                                if (num.get(j).equals("(")) {
//                            System.out.println("Мы нашли ее открвывающую скобку, ура, она находится в позиции: " + j);
                                    indifCloseBracket = i;
                                    indifOpenBracket = j;
                                    break;
                                }
                            }
                            break;
                        }
                    }


                    //                   ЕСЛИ СКОБОК НЕТ       то нужно тупо решить пример

                    // нужно решить пример соблюдая приоритетность
                    if (!ContainBrackets) {
                        double resultIn = 0; //сюда мы будем закидывать результат решения
                        // проверяем есть ли * или /
                        for (int j = 0; j < num.size(); j++) {
                            if (num.get(j).equals("*")
                                    || num.get(j).equals("^")
                                    || num.get(j).equals("/")
                                    || num.get(j).equals("+")
                                    || num.get(j).equals("-")) { // если мы нашли какой-то знак


                                Boolean timesDel1 = false; // индикатор наличия * или /
                                for (int k = 0; k < num.size(); k++) {
                                    // соблюдаем приоритетность знаков, рассматриваем * и / в первую очередь
                                    if (num.get(k).equals("*") || num.get(k).equals("/") || num.get(k).equals("^")) {
                                        if (num.get(k).equals("*")) {
                                            resultIn = Double.parseDouble(num.get(k - 1)) * Double.parseDouble(num.get(k + 1));
//                                        System.out.println("Выполнилось умножение");
//                                            System.out.println(num.get(k - 1) + " умножили на " + num.get(k + 1));
                                        } else if (num.get(k).equals("/")) {
                                            resultIn = (Double.parseDouble(num.get(k - 1)) / Double.parseDouble(num.get(k + 1)));
//                                        System.out.println("Выполнилось деление");
//                                            System.out.println(num.get(k - 1) + " разделили на " + num.get(k + 1));
                                        } else if (num.get(k).equals("^")) {
                                            resultIn = pow((Double.parseDouble(num.get(k - 1))), Double.parseDouble(num.get(k + 1)));
//                                        System.out.println("Выполнилось деление");
//                                            System.out.println(num.get(k - 1) + " в степени " + num.get(k + 1));
                                        }

                                        // Мы точно знаем, что в j позиции находится знак, значит j-1 и j+1 есть числа,
                                        // которые мы уже посчитали
                                        // это значит, что мы можем из Дмассива сократить позиции j-1, j и j+1
                                        num.remove(k - 1);
                                        num.remove(k - 1);
                                        num.remove(k - 1);
                                        // закинем ответ в Дмассив вместо решенного кусочка примера
                                        num.add(k - 1, Double.toString(resultIn));

                                        timesDel1 = true;
                                    }
                                }
                                if (timesDel1) {
                                    break;
                                }// индикатор наличия * или /


                                // если внутри нет * и /, то можем рассматривать + и -
                                if (num.get(j).equals("+") || num.get(j).equals("-")) {
                                    if (num.get(j).equals("+")) {
                                        resultIn = Double.parseDouble(num.get(j - 1)) + Double.parseDouble(num.get(j + 1));
//                                    System.out.println("Выполнилось сложение");
//                                        System.out.println(num.get(j - 1) + " сложили с " + num.get(j + 1));
                                    } else {
                                        resultIn = Double.parseDouble(num.get(j - 1)) - Double.parseDouble(num.get(j + 1));
//                                    System.out.println("Выполнилось вычитание");
//                                        System.out.println(num.get(j - 1) + " отняли от " + num.get(j + 1));
                                    }
                                    // Мы точно знаем, что в j позиции находится знак, значит j-1 и j+1 есть числа,
                                    // которые мы уже посчитали
                                    // это значит, что мы можем из Дмассива сократить позиции j-1, j и j+1
                                    // закинем ответ в Дмассив вместо решенного кусочка примера
                                    num.add(j - 1, Double.toString(resultIn));

                                    num.remove(j);
                                    num.remove(j);
                                    num.remove(j);

                                    break;
                                }
                            }
                        }
                    }


                    //                РЕШАЕМ ПРИМЕР ВНУРИ СКОБОК

                    // после решения очередного действия мне нужно занести это решение в отдельную ячейку
                    // и узнать позиции решенных чисел и знака, чтобы сократить Дмассив в нужном месте

                    // идем по массиву, начиная с открывающей скобки и до закрывающей
                    double resultInBracket = 0; //сюда мы будем закидывать результат решения внутри скобки
                    // проверяем есть ли в скобках * или /
                    for (int j = indifOpenBracket + 1; j <= indifCloseBracket - 1; j++) {
                        if (indifOpenBracket != indifCloseBracket - 3 &&
                                (num.get(j).equals("*")
                                        || num.get(j).equals("^")
                                        || num.get(j).equals("/")
                                        || num.get(j).equals("+")
                                        || num.get(j).equals("-"))) { // если мы нашли какой-то знак
//                        System.out.println("Ура, мы нашли какой-то знак");


                            Boolean timesDel1 = false; // индикатор наличия * или /
                            for (int k = indifOpenBracket + 1; k < indifCloseBracket - 1; k++) {
                                // соблюдаем приоритетность знаков, рассматриваем * и / в первую очередь
                                if (num.get(k).equals("*") || num.get(k).equals("/") || num.get(k).equals("^")) {
                                    if (num.get(k).equals("*")) {
                                        resultInBracket = Double.parseDouble(num.get(k - 1)) * Double.parseDouble(num.get(k + 1));
//                                        System.out.println("Выполнилось умножение");
//                                        System.out.println(num.get(k - 1) + " умножили на " + num.get(k + 1));
                                    } else if (num.get(k).equals("^")) {
                                        resultInBracket = pow((Double.parseDouble(num.get(k - 1))), Double.parseDouble(num.get(k + 1)));
//                                        System.out.println("Выполнилось деление");
//                                        System.out.println(num.get(k - 1) + " в степени " + num.get(k + 1));
                                    } else if (num.get(k).equals("/")) {
                                        resultInBracket = Double.parseDouble(num.get(k - 1)) / Double.parseDouble(num.get(k + 1));
//                                        System.out.println("Выполнилось деление");
//                                        System.out.println(num.get(k - 1) + " разделили на " + num.get(k + 1));
                                    }

                                    // Мы точно знаем, что в j позиции находится знак, значит j-1 и j+1 есть числа,
                                    // которые мы уже посчитали
                                    // это значит, что мы можем из Дмассива сократить позиции j-1, j и j+1
                                    num.remove(k - 1);
                                    num.remove(k - 1);
                                    num.remove(k - 1);
                                    // закинем ответ в Дмассив вместо решенного кусочка примера
                                    num.add(k - 1, Double.toString(resultInBracket));

                                    timesDel1 = true;
                                }
                            }
                            if (timesDel1) {
                                break;
                            }// индикатор наличия * или /


                            // если внутри рассматриваемых скобок нет умн и дел, то можем рассматривать + и
                            if (num.get(j).equals("+") || num.get(j).equals("-")) {
                                if (num.get(j).equals("+")) {
                                    resultInBracket = Double.parseDouble(num.get(j - 1)) + Double.parseDouble(num.get(j + 1));
//                                    System.out.println("Выполнилось сложение");
//                                    System.out.println(num.get(j - 1) + " сложили с " + num.get(j + 1));
                                } else {
                                    resultInBracket = Double.parseDouble(num.get(j - 1)) - Double.parseDouble(num.get(j + 1));
//                                    System.out.println("Выполнилось вычитание");
//                                    System.out.println(num.get(j - 1) + " отняли от " + num.get(j + 1));
                                }
                                // Мы точно знаем, что в j позиции находится знак, значит j-1 и j+1 есть числа,
                                // которые мы уже посчитали
                                // это значит, что мы можем из Дмассива сократить позиции j-1, j и j+1
                                // закинем ответ в Дмассив вместо решенного кусочка примера
                                num.add(j - 1, Double.toString(resultInBracket));

                                num.remove(j);
                                num.remove(j);
                                num.remove(j);

                                break;
                            }
                        }


                        // если между открывающей и закрывающей скобкой только одна цифра
                        // то уберем эти скобки
                        if (indifOpenBracket == indifCloseBracket - 2) {
//                            System.out.println("Убираем уже ненужные скобки ");
                            num.remove(indifOpenBracket);
                            num.remove(indifCloseBracket - 1);
                            break;
                        }
                    }


            /*System.out.println("num.size()= " + num.size());
            System.out.println("NumSize= " + num.size());
            System.out.print("num: ");
            for (
                    int k = 0; k < num.size(); k++) {
                System.out.print(num.get(k) + "");
            }
            System.out.println();
            System.out.println();
            System.out.println();// Проверка на прочность

            System.out.println("Ответ= " + num.get(0));
            */

                }


                resText.setText(OldTextString + " = " + num.get(0));
            }
        }
    }
    public void onButtonClick0(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (OldTextString.equals("0")) {
        } else if (s[s.length - 1].equals(")")) {
            resText.setText(OldTextString + "*" + "0");
        } else resText.setText(OldTextString + 0);
    } //+
    public void onButtonClick1(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (OldTextString.equals("0")) {
            resText.setText("1");
        } else if (s[s.length - 1].equals(")")) {
            resText.setText(OldTextString + "*" + "1");
        } else resText.setText(OldTextString + 1);

    } //+
    public void onButtonClick2(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (OldTextString.equals("0")) {
            resText.setText("1");
        } else if (s[s.length - 1].equals(")")) {
            resText.setText(OldTextString + "*" + "2");
        } else resText.setText(OldTextString + 2);
    } //+
    public void onButtonClick3(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (OldTextString.equals("0")) {
            resText.setText("1");
        } else if (s[s.length - 1].equals(")")) {
            resText.setText(OldTextString + "*" + "3");
        } else resText.setText(OldTextString + 3);
    } //+
    public void onButtonClick4(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (OldTextString.equals("0")) {
            resText.setText("1");
        } else if (s[s.length - 1].equals(")")) {
            resText.setText(OldTextString + "*" + "4");
        } else resText.setText(OldTextString + 4);
    } //+
    public void onButtonClick5(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (OldTextString.equals("0")) {
            resText.setText("1");
        } else if (s[s.length - 1].equals(")")) {
            resText.setText(OldTextString + "*" + "5");
        } else resText.setText(OldTextString + 5);
    } //+
    public void onButtonClick6(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (OldTextString.equals("0")) {
            resText.setText("1");
        } else if (s[s.length - 1].equals(")")) {
            resText.setText(OldTextString + "*" + "6");
        } else resText.setText(OldTextString + 6);
    } //+
    public void onButtonClick7(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (OldTextString.equals("0")) {
            resText.setText("1");
        } else if (s[s.length - 1].equals(")")) {
            resText.setText(OldTextString + "*" + "7");
        } else resText.setText(OldTextString + 7);
    } //+
    public void onButtonClick8(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (OldTextString.equals("0")) {
            resText.setText("1");
        } else if (s[s.length - 1].equals(")")) {
            resText.setText(OldTextString + "*" + "8");
        } else resText.setText(OldTextString + 8);
    } //+
    public void onButtonClick9(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        String[] s = OldTextString.split("");
        if (OldTextString.equals("0")) {
            resText.setText("1");
        } else if (s[s.length - 1].equals(")")) {
            resText.setText(OldTextString + "*" + "9");
        } else resText.setText(OldTextString + 9);
    } //+
    public void onButtonClickPoint(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String

        // !!! прежде чем ставить точку, нужно посмотреть были ли точки ранее
        String[] s = OldTextString.split("");
        /*Boolean b = true;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(".") ) {
                b = false;
                break;
            }
        }
        if (b) {*/
        if (OldTextString.equals("") && (
                !s[s.length - 1].equals("(")
                        || !s[s.length - 1].equals("*")
                        || !s[s.length - 1].equals("/")
                        || !s[s.length - 1].equals("+")
                        || !s[s.length - 1].equals("-")
                        || !s[s.length - 1].equals("^"))) {
            resText.setText(OldTextString + "0" + "."); // тут все в String формате
        } else resText.setText(OldTextString + "."); // тут все в String формате
    }
    public void onButtonClickX(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String

        String[] s = OldTextString.split(""); //разбиваем на символы
        int l = s.length - 1;
        System.out.println("l " + l);
        String ss = "";
        for (int i = 0; i < l; i++) {
            ss += s[i];
        }
        resText.setText(ss);
    } //+
    public void onButtonClickC(View v) {
        EditText resText = (EditText) findViewById(R.id.Result);
        String OldTextString = resText.getText().toString(); // перевод из текстового формата в String
        resText.setText(""); // тут все в String формате
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnDrob:
                intent = new Intent("Activity_Drob");
                startActivity(intent);
                break;
            case R.id.currency:
                intent = new Intent("Activity_currency");
                startActivity(intent);
        }
    }
}