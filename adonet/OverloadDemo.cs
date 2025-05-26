// OverloadDemo.cs
using System;

namespace UniqueAdoNetExercises
{
    class QuantumCalculator
    {
        public string CalculateTotal(int a, int b) => $"Integer sum: {a + b}";
        public string CalculateTotal(double x, double y, double z) => $"Double sum: {x + y + z}";
        public string CalculateTotal(params int[] numbers) => $"Variable sum: {string.Join("+", numbers)} = {numbers.Sum()}";
    }

    class Program
    {
        static void Main()
        {
            var calculator = new QuantumCalculator();
            
            Console.WriteLine(calculator.CalculateTotal(3, 7));
            Console.WriteLine(calculator.CalculateTotal(1.5, 2.5, 3.5));
            Console.WriteLine(calculator.CalculateTotal(2, 4, 6, 8, 10));
        }
    }
}