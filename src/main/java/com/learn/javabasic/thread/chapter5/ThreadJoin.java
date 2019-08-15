package com.learn.javabasic.thread.chapter5;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1_00; i++) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1_00; i++) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("All of tasks finish done");
        for (int i = 0; i < 1_00; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }


    }
}


/**
 * Thread-0  0
 * Thread-1  0
 * Thread-0  1
 * Thread-1  1
 * Thread-0  2
 * Thread-1  2
 * Thread-0  3
 * Thread-1  3
 * Thread-0  4
 * Thread-1  4
 * Thread-0  5
 * Thread-1  5
 * Thread-0  6
 * Thread-0  7
 * Thread-1  6
 * Thread-0  8
 * Thread-1  7
 * Thread-0  9
 * Thread-1  8
 * Thread-0  10
 * Thread-1  9
 * Thread-0  11
 * Thread-1  10
 * Thread-0  12
 * Thread-1  11
 * Thread-0  13
 * Thread-0  14
 * Thread-0  15
 * Thread-0  16
 * Thread-0  17
 * Thread-0  18
 * Thread-1  12
 * Thread-0  19
 * Thread-1  13
 * Thread-0  20
 * Thread-1  14
 * Thread-0  21
 * Thread-1  15
 * Thread-0  22
 * Thread-1  16
 * Thread-0  23
 * Thread-1  17
 * Thread-0  24
 * Thread-1  18
 * Thread-0  25
 * Thread-1  19
 * Thread-0  26
 * Thread-1  20
 * Thread-0  27
 * Thread-1  21
 * Thread-0  28
 * Thread-1  22
 * Thread-0  29
 * Thread-1  23
 * Thread-0  30
 * Thread-1  24
 * Thread-0  31
 * Thread-1  25
 * Thread-0  32
 * Thread-1  26
 * Thread-0  33
 * Thread-1  27
 * Thread-0  34
 * Thread-1  28
 * Thread-0  35
 * Thread-1  29
 * Thread-0  36
 * Thread-1  30
 * Thread-0  37
 * Thread-1  31
 * Thread-0  38
 * Thread-0  39
 * Thread-0  40
 * Thread-0  41
 * Thread-0  42
 * Thread-0  43
 * Thread-0  44
 * Thread-0  45
 * Thread-0  46
 * Thread-0  47
 * Thread-1  32
 * Thread-0  48
 * Thread-1  33
 * Thread-0  49
 * Thread-1  34
 * Thread-0  50
 * Thread-1  35
 * Thread-0  51
 * Thread-1  36
 * Thread-0  52
 * Thread-1  37
 * Thread-0  53
 * Thread-1  38
 * Thread-0  54
 * Thread-1  39
 * Thread-0  55
 * Thread-1  40
 * Thread-0  56
 * Thread-1  41
 * Thread-0  57
 * Thread-1  42
 * Thread-0  58
 * Thread-1  43
 * Thread-0  59
 * Thread-1  44
 * Thread-0  60
 * Thread-1  45
 * Thread-0  61
 * Thread-1  46
 * Thread-0  62
 * Thread-1  47
 * Thread-0  63
 * Thread-1  48
 * Thread-0  64
 * Thread-1  49
 * Thread-0  65
 * Thread-1  50
 * Thread-0  66
 * Thread-1  51
 * Thread-0  67
 * Thread-1  52
 * Thread-0  68
 * Thread-1  53
 * Thread-0  69
 * Thread-0  70
 * Thread-1  54
 * Thread-1  55
 * Thread-1  56
 * Thread-0  71
 * Thread-1  57
 * Thread-0  72
 * Thread-0  73
 * Thread-1  58
 * Thread-0  74
 * Thread-1  59
 * Thread-0  75
 * Thread-1  60
 * Thread-0  76
 * Thread-1  61
 * Thread-0  77
 * Thread-1  62
 * Thread-0  78
 * Thread-1  63
 * Thread-0  79
 * Thread-1  64
 * Thread-0  80
 * Thread-1  65
 * Thread-0  81
 * Thread-1  66
 * Thread-0  82
 * Thread-1  67
 * Thread-1  68
 * Thread-1  69
 * Thread-1  70
 * Thread-1  71
 * Thread-1  72
 * Thread-1  73
 * Thread-1  74
 * Thread-1  75
 * Thread-1  76
 * Thread-1  77
 * Thread-1  78
 * Thread-1  79
 * Thread-1  80
 * Thread-1  81
 * Thread-1  82
 * Thread-1  83
 * Thread-1  84
 * Thread-1  85
 * Thread-1  86
 * Thread-1  87
 * Thread-1  88
 * Thread-1  89
 * Thread-1  90
 * Thread-1  91
 * Thread-1  92
 * Thread-0  83
 * Thread-1  93
 * Thread-0  84
 * Thread-1  94
 * Thread-0  85
 * Thread-1  95
 * Thread-0  86
 * Thread-1  96
 * Thread-0  87
 * Thread-1  97
 * Thread-0  88
 * Thread-1  98
 * Thread-0  89
 * Thread-1  99
 * Thread-0  90
 * Thread-0  91
 * Thread-0  92
 * Thread-0  93
 * Thread-0  94
 * Thread-0  95
 * Thread-0  96
 * Thread-0  97
 * Thread-0  98
 * Thread-0  99
 * All of tasks finish done
 * main  0
 * main  1
 * main  2
 * main  3
 * main  4
 * main  5
 * main  6
 * main  7
 * main  8
 * main  9
 * main  10
 * main  11
 * main  12
 * main  13
 * main  14
 * main  15
 * main  16
 * main  17
 * main  18
 * main  19
 * main  20
 * main  21
 * main  22
 * main  23
 * main  24
 * main  25
 * main  26
 * main  27
 * main  28
 * main  29
 * main  30
 * main  31
 * main  32
 * main  33
 * main  34
 * main  35
 * main  36
 * main  37
 * main  38
 * main  39
 * main  40
 * main  41
 * main  42
 * main  43
 * main  44
 * main  45
 * main  46
 * main  47
 * main  48
 * main  49
 * main  50
 * main  51
 * main  52
 * main  53
 * main  54
 * main  55
 * main  56
 * main  57
 * main  58
 * main  59
 * main  60
 * main  61
 * main  62
 * main  63
 * main  64
 * main  65
 * main  66
 * main  67
 * main  68
 * main  69
 * main  70
 * main  71
 * main  72
 * main  73
 * main  74
 * main  75
 * main  76
 * main  77
 * main  78
 * main  79
 * main  80
 * main  81
 * main  82
 * main  83
 * main  84
 * main  85
 * main  86
 * main  87
 * main  88
 * main  89
 * main  90
 * main  91
 * main  92
 * main  93
 * main  94
 * main  95
 * main  96
 * main  97
 * main  98
 * main  99
 *
 * Process finished with exit code 0
 */
