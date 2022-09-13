package com.intern.callvideoservice.base

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.containers.wait.strategy.Wait
import java.io.File
import java.time.Duration

class BaseITInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
    companion object {
        class KDockerComposeContainer(file: File) : DockerComposeContainer<KDockerComposeContainer>(file)

        class Container(
            val serviceName: String,
            val port: Int
        )

        private val MYSQL = Container("call_video_service_test", 3368)

        private val POSTGRES = Container("postgres_1", 5432)
//        Wait.forListeningPort().withStartupTimeout(Duration.ofSeconds(120))
//            .withOptions("--compatibility")
        private val COMPOSE_CONTAINER: KDockerComposeContainer by lazy {
            KDockerComposeContainer(File("docker-compose.yml"))
                .withExposedService(MYSQL.serviceName, MYSQL.port)
                .withLocalCompose(true)
        }
    }

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        COMPOSE_CONTAINER.start()
        val containerUrl = getContainerUrl(MYSQL)
        System.out.println("containerUrl: $containerUrl")
        val jdbcURL = "jdbc:postgresql://${getContainerUrl(MYSQL)}:${MYSQL.port}/callvideoservice"

        TestPropertyValues.of(
            "spring.datasource.url=$jdbcURL"
        ).applyTo(applicationContext.environment)
    }

    private fun getContainerUrl(container: Container) =
        COMPOSE_CONTAINER.getServiceHost(container.serviceName, container.port)





}