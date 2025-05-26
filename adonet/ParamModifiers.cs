// ParamModifiers.cs
using System;

namespace UniqueAdoNetExercises
{
    class Program
    {
        static void ModifyWithRef(ref int value)
        {
            value = (int)(value * 1.618); // Golden ratio
        }

        static void GetQuantumState(out string state)
        {
            state = DateTime.Now.Ticks % 2 == 0 ? "Superposition" : "Collapsed";
        }

        static void ReadOnlyDemo(in DateTime fixedDate)
        {
            Console.WriteLine($"Date is locked at: {fixedDate:yyyy-MM-dd}");
            // fixedDate = DateTime.Now; // Would cause error
        }

        static void Main()
        {
            int number = 100;
            Console.WriteLine($"Original number: {number}");
            ModifyWithRef(ref number);
            Console.WriteLine($"After ref modification: {number}");

            GetQuantumState(out string particleState);
            Console.WriteLine($"Quantum state: {particleState}");

            var creationDate = new DateTime(2023, 1, 1);
            ReadOnlyDemo(in creationDate);
        }
    }
}