package saidur.demo.kotlin

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Scope

@Scope
@Retention(RetentionPolicy.RUNTIME)
internal annotation class DemoScope
