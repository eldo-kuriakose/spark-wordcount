import java.lang.Math
import java.lang.Math

print("** To run from file > spark-shell -i wordcount.scala ** \n")
val textFile = sc.textFile("../README.md")
print("** Total words \n")
textFile.count()

print("** First word \n")
textFile.first()

textFile.map(line => line.split(" ").size).reduce((a, b) => Math.max(a, b))

val wordCounts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey((a, b) => a + b)

print("** Word count in README file: \n")

wordCounts.collect()