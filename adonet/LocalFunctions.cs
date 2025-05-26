// LocalFunctions.cs
using System;

namespace UniqueAdoNetExercises
{
    class Program
    {
        static void Main()
        {
            Console.WriteLine("Enter a positive integer for factorial calculation:");
            if (int.TryParse(Console.ReadLine(), out int n) && n >= 0)
            {
                Console.WriteLine($"{n}! = {CalculateFactorial(n)}");
            }
            else
            {
                Console.WriteLine("Invalid input. Please enter a non-negative integer.");
            }
        }

        static long CalculateFactorial(int number)
        {
            if (number > 20) throw new ArgumentException("Value too large for long type.");

            long Factorial(int x) => x <= 1 ? 1 : x * Factorial(x - 1);

            return Factorial(number);
        }
    }
}