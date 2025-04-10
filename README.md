# Thread File Reader 📁🧵

This is a multithreaded Java application that reads multiple `.txt` files in parallel using `ExecutorService`.

## 🔧 What It Does

- Reads `.txt` files inside the `/files` directory
- Uses a thread pool to process them concurrently
- Counts and prints the number of lines per file

## 💻 Tech Used

- Java 21
- ExecutorService
- BufferedReader

## 👨‍💻 Sample Output

pool-1-thread-1 → files/file1.txt: 4 lines
pool-1-thread-3 → files/file2.txt: 19 lines
pool-1-thread-2 → files/file3.txt: 6 lines

## 🚀 How to Run

1. Place `.txt` files inside `files/`
2. Compile and run `Main.java`

