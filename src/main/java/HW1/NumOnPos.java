package HW1;

import java.util.Scanner;

public class NumOnPos {
    public static void main(String[] args) {
        long pos = new Scanner(System.in).nextLong() + 1;
        //текущая длинна чисел
        long curNumLength = 1;
        //текущая максимальная позиция цифры для чисел длинны curNumLength
        long curLimit = 10;
        //текущее число, ниже которого лежат все числа длинны curNumLength
        long curPos = 9;

        //ищем максимальную позицию цифры (curPos) числа, длинна которого равна
        //curNumLength, но при этом curPos должен быть больше входной позиции (pos)
        while (pos > curPos) {
            curNumLength++;
            curPos += curNumLength * curLimit * 9;
            curLimit *= 10;
        }

        //По разности curPos и pos находим само число
        long num = curLimit - 1 - (curPos - pos) / curNumLength;
        //и номер цифры в нём
        int digitPos = (int) ((curPos - pos) % curNumLength);

        //выводим нужную цифру используя остаток деления на степень 10
        long pow10 = 1;
        while (digitPos-- > 0) pow10 *= 10;
        System.out.println(num / pow10 % 10);
    }
}
