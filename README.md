# demo-concurrent

并发请求例子

代码：

```java
final CountDownLatch begin = new CountDownLatch(1);

final ExecutorService executorService = Executors.newFixedThreadPool(10);

for (int i = 0; i < 100; i++) {
    final int NO = i + 1;
    Runnable run = new Runnable() {
        public void run() {
            try {
                begin.await();
                System.out.println("第 " + NO + " 条数据开始执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    // 相当于：同时有10个客户端请求，每个客户端发送10条数据（总共发送100条数据）
    executorService.submit(run);
}

System.out.println("开始执行......");
begin.countDown();
executorService.shutdown();
```
