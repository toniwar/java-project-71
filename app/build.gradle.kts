
plugins {
    application
    id("checkstyle")
}

application {
    mainClass.set("hexlet.code.App")
}

tasks.withType<JavaCompile> {
    options.release = 20
}
group = "io.hexlet"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://mvnrepository.com/artifact/info.picocli/picocli
    implementation("info.picocli:picocli:4.7.5")
    annotationProcessor("info.picocli:picocli-codegen:4.7.5")

}

tasks.test {
    useJUnitPlatform()
}

