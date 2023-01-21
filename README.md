# Java 隨機亂數產生器

一般來說我們產生一個隨機亂數通常是採用uniform distribution去產出。

這次的產生器可支援不一樣的分布來產出亂數。
- uniform distribution
- geometric distribution
- exponential distribution

## 用法
在命令列如下:
>java -jar random.jar

它會從( 0,int max )以uniform distribution的分布挑一數字，預設為小數。
<br></br>
若要查詢其他參數的相關用法請使用 -help
> java -jar random.jar -help

