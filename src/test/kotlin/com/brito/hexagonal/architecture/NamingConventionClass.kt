package com.brito.hexagonal.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes

@AnalyzeClasses(packages = ["com.brito.hexagonal"])
class NamingConventionClass {

    @ArchTest
    val `consumer reside only consumer package` = classes()
        .that()
        .haveNameMatching(".*Consumer")
        .should()
        .resideInAPackage("..adapters.in.consumer..")
        .`as`("Consumer classes should reside in the consumer package")

    @ArchTest
    val `message reside only message package` = classes()
        .that()
        .haveNameMatching(".*Message")
        .should()
        .resideInAPackage("..adapters.in.consumer.message..")
        .`as`("Message classes should reside in the message package")


    @ArchTest
    val `controller reside only controller package` = classes()
        .that()
        .haveNameMatching(".*Controller")
        .should()
        .resideInAPackage("..adapters.in.controller..")
        .`as`("Controller classes should reside in the controller package")

    @ArchTest
    val `response reside only response package` = classes()
        .that()
        .haveNameMatching(".*Response")
        .should()
        .resideInAnyPackage("..adapters.in.controller.response..", "..adapters.out.client.response..")
        .`as`("Response classes should reside in the response package")


    @ArchTest
    val `request reside only request package` = classes()
        .that()
        .haveNameMatching(".*Request")
        .should()
        .resideInAnyPackage("..adapters.in.controller.request..", "..adapters.out.client.request..")
        .`as`("Request classes should reside in the request package")

    @ArchTest
    val `adapter reside only adapter package` = classes()
        .that()
        .haveNameMatching(".*Adapter")
        .should()
        .resideInAPackage("..adapters.out..")
        .`as`("Adapter classes should reside in the adapter package")

    @ArchTest
    val `client reside only client package` = classes()
        .that()
        .haveNameMatching(".*Client")
        .should()
        .resideInAPackage("..adapters.out.client..")
        .`as`("Client classes should reside in the client package")

    @ArchTest
    val `repository reside only repository package` = classes()
        .that()
        .haveNameMatching(".*Repository")
        .should()
        .resideInAPackage("..adapters.out.repository..")
        .`as`("Repository classes should reside in the repository package")

    @ArchTest
    val `entity reside only entity package` = classes()
        .that()
        .haveNameMatching(".*Entity")
        .should()
        .resideInAPackage("..adapters.out.repository.entity..")
        .`as`("Entity classes should reside in the entity package")

    @ArchTest
    val `usecase reside only usecase package` = classes()
        .that()
        .haveNameMatching(".*UseCase")
        .should()
        .resideInAPackage("..application.core.usecase..")
        .`as`("UseCase classes should reside in the usecase package")

    @ArchTest
    val `input port reside only input port package` = classes()
        .that()
        .haveNameMatching(".*InputPort")
        .should()
        .resideInAPackage("..application.ports.in..")
        .`as`("InputPort classes should reside in the input port package")

    @ArchTest
    val `output port reside only output port package` = classes()
        .that()
        .haveNameMatching(".*OutputPort")
        .should()
        .resideInAPackage("..application.ports.out..")
        .`as`("OutputPort classes should reside in the output port package")

    @ArchTest
    val `config reside only config package` = classes()
        .that()
        .haveNameMatching(".*Config")
        .should()
        .resideInAPackage("..hexagonal.config..")
        .`as`("Config classes should reside in the config package")

    @ArchTest
    val `should be suffixed consumer` = classes()
        .that()
        .resideInAPackage("..consumer")
        .should()
        .haveSimpleNameEndingWith("Consumer")

    @ArchTest
    val `should be suffixed message` = classes()
        .that()
        .resideInAPackage("..message")
        .should()
        .haveSimpleNameEndingWith("Message")

    @ArchTest
    val `should be suffixed controller` = classes()
        .that()
        .resideInAPackage("..controller")
        .should()
        .haveSimpleNameEndingWith("Controller")

    @ArchTest
    val `should be suffixed response` = classes()
        .that()
        .resideInAPackage("..response")
        .should()
        .haveSimpleNameEndingWith("Response")

    @ArchTest
    val `should be suffixed request` = classes()
        .that()
        .resideInAPackage("..request")
        .should()
        .haveSimpleNameEndingWith("Request")

    @ArchTest
    val `should be suffixed client` = classes()
        .that()
        .resideInAPackage("..client")
        .should()
        .haveSimpleNameEndingWith("Client")

    @ArchTest
    val `should be suffixed repository` = classes()
        .that()
        .resideInAPackage("..repository")
        .should()
        .haveSimpleNameEndingWith("Repository")

    @ArchTest
    val `should be suffixed entity` = classes()
        .that()
        .resideInAPackage("..entity")
        .should()
        .haveSimpleNameEndingWith("Entity")

    @ArchTest
    val `should be suffixed adapter` = classes()
        .that()
        .resideInAPackage("..adapters.out")
        .should()
        .haveSimpleNameEndingWith("Adapter")

    @ArchTest
    val `should be suffixed usecase` = classes()
        .that()
        .resideInAPackage("..usecase")
        .should()
        .haveSimpleNameEndingWith("UseCase")

    @ArchTest
    val `should be suffixed input port` = classes()
        .that()
        .resideInAPackage("..ports.in")
        .should()
        .haveSimpleNameEndingWith("InputPort")

    @ArchTest
    val `should be suffixed output port` = classes()
        .that()
        .resideInAPackage("..ports.out")
        .should()
        .haveSimpleNameEndingWith("OutputPort")

    @ArchTest
    val `should be suffixed config` = classes()
        .that()
        .resideInAPackage("..config")
        .should()
        .haveSimpleNameEndingWith("Config")
}