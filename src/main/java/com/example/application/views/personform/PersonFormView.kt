package com.example.application.views.personform

import com.example.application.PersonRecord
import com.example.application.PersonRepository
import com.example.application.views.MainLayout
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route
import java.time.LocalDateTime

@Route("/personForm", layout = MainLayout::class)
class PersonFormPage : Div() {
    private val firstNameField: TextField = TextField("First name")
    private val birthDateField: DatePicker = DatePicker("Birth date").apply {
        isRequired = true
    }

    private val saveButton = Button("Save").apply {
        addClickListener {
            PersonRepository.insertPerson(
                PersonRecord(
                    firstName = firstNameField.value,
                    lastName = "LastName" + LocalDateTime.now().second,
                    email = "email@",
                    phone = "1432124",
                    birth = birthDateField.value,
                    occupation = "141234fsda",
                )
            )
        }
    }

    init {
        add(
            VerticalLayout().apply {
                add(firstNameField, birthDateField)
                add(saveButton)
            }
        )
    }
}