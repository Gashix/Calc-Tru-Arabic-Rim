import java.util.Scanner;

    public class Main {

        static String result;


        public static void main(String[] args) {

            System.out.println(calc(result));
        }

                public static String calc (String input){
            try{
                    int result;

                Converter converter = new Converter();
                String[] actions = {"+", "-", "/", "*"};
                String[] regexActions = {"\\+", "-", "/", "\\*"};
                System.out.print("Введите выражение: ");
                Scanner scn = new Scanner(System.in);
                String exp = scn.nextLine();
                exp = exp.replaceAll(" ", "");


                    //Определяем арифметическое действие:
                    int actionIndex = -1;
                    for (int i = 0; i < actions.length; i++) {
                        if (exp.contains(actions[i])) {
                            actionIndex = i;
                            break;
                        }
                    }
                    //Если не нашли арифметического действия, завершаем программу
                    if (actionIndex == -1) {
                        System.out.println("Некорректное выражение");
                        return null;
                    }

                    //Делим строчку по найденному арифметическому знаку
                    String[] data = exp.split(regexActions[actionIndex]);
                    if (exp.length()<3){System.out.println("напишите выражение правильно"); return null;}
                    //Определяем, находятся ли числа в одном формате (оба римские или оба арабские)
                    if (converter.isRoman(data[0]) == converter.isRoman(data[1])){
                        if (data.length>2){ System.out.println("калькулятор работает только с двумя числами");
                            return null;}
                        int a, b;
                        //Определяем, римские ли это числа
                        boolean isRoman = converter.isRoman(data[0]);
                        if (isRoman) {
                            //если римские, то конвертируем их в арабские
                            //X+V
                            //x-10
                            //v - 5
                            a = converter.romanToInt(data[0]);
                            b = converter.romanToInt(data[1]);

                        } else {
                            //если арабские, конвертируем их из строки в число
                            a = Integer.parseInt(data[0]);
                            b = Integer.parseInt(data[1]);
                        }
                        //выполняем с числами арифметическое действие
                        if (-10 <= a && a < 11 && -10 <= b && b < 11) {

                            switch (actions[actionIndex]) {
                                case "+":
                                    result = a + b;
                                    break;
                                case "-":
                                    result = a - b;
                                    break;
                                case "*":
                                    result = a * b;
                                    break;
                                default:
                                    result = a / b;
                                    break;
                            }
                            //15->XV
                            if (isRoman) {
                                //если числа были римские, возвращаем результат в римском числе
                                if (a > 0 && b > 0 && result > 0)
                                    //System.out.println(converter.intToRoman(result));
                                return String.valueOf(converter.intToRoman(result));

                                else System.out.println("римские числа не могут быть отрицательными");
                                return String.valueOf(converter.intToRoman(result));
                            } else {
                                //если числа были арабские, возвращаем результат в арабском числе
                               // System.out.println(result);
                                return String.valueOf(result);
                            }
                        } else System.out.println("калькулятор работает с числами от 1 до 10 включительно");
                    } else {
                        System.out.println("Числа должны быть в одном формате");
                    }



                }catch (Throwable error){System.out.println("непредвиденная ошиба");}
                    return null;
                }
             {
                System.out.println("Неверно введены данные");
            }
        }

