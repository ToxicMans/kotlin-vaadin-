package com.example.application.views.personform

import com.example.application.PersonRecord
import com.example.application.PersonRepository
import com.example.application.views.MainLayout
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.H3
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route


@Route("/personForm", layout = MainLayout::class)
class PersonFormPage : VerticalLayout() {

    private val firstNameField: TextField = TextField("First name")
    private val birthDateField: DatePicker = DatePicker("Birth date")
    private val lastNameField: TextField = TextField("Last Name")
    private val emailField: TextField = TextField("Email")
    private val phoneField: TextField = TextField("Phone")
    private val occupationField: TextField = TextField("Occupation")

    private val saveButton = Button("Save").apply {
        addClickListener {
            PersonRepository.insertPerson(
                PersonRecord(
                    firstName = firstNameField.value,
                    lastName = firstNameField.value,
                    email = firstNameField.value,
                    phone = occupationField.value,
                    birth = birthDateField.value,
                    occupation = occupationField.value
                )
            )
        }
    }

    init {
        isMargin = true//Отступ
        add(
            H3("Person Page"),
            HorizontalLayout(firstNameField, lastNameField),
            HorizontalLayout(birthDateField, phoneField),
            HorizontalLayout(emailField, occupationField),
            saveButton
        )
    }
}

