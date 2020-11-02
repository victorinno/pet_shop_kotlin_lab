FROM openjdk:14-alpine
COPY target/pet_shop_kotlin_lab-*.jar pet_shop_kotlin_lab.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "pet_shop_kotlin_lab.jar"]