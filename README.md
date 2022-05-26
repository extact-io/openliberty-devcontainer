# openliberty-devcontainer
> 豆蔵デベロッパーサイトのブログ記事で利用しているサンプルアプリ

## 利用している記事

|記事| 利用内容 |
|---|---|
|[OpenLibertyとVSCodeによるコンテナを用いた開発環境の構築](https://developer.mamezou-tech.com/blogs/2022/05/26/openliberty-devcontainer/)| liberty-maven-pluginを使ったコンテナ環境のサンプル|

## ビルドと実行
サンプルアプリのビルドにはDocker環境とMavenが必要です

``` shell
# Clone this repository
git clone https://github.com/extact-io/openliberty-devcontainer.git
# Go into the repository
cd openliberty-devcontainer
# Run the app
mvn liberty:devc
```
