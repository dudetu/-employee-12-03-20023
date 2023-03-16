import java.util.Random;
import java.util.stream.IntStream;


//Напишите метод,
// который будет генерировать поток случайных чисел заданного размера (в смысле размер потока,
// например 10 000 чисел) и определять долю нечетных чисел в нем.
    public class RandomStream {
        public static double getOddRatio(int size) {
            Random random = new Random();
            IntStream stream = random.ints(size);
            long oddCount = stream.filter(num -> num % 2 != 0).count();
            return (double) oddCount / size;
        }
    }


