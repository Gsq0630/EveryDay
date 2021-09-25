package com.example.aninterface

import kotlin.annotation.AnnotationTarget.FIELD

@Target(FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Autowired(val a: String = "")

@Target(FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class ResId(val a: Int)
