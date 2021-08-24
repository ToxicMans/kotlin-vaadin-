package com.example.application.views.helloworld

import com.example.application.PersonRecord
import com.example.application.PersonRepository
import com.example.application.views.MainLayout
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.orderedlayout.HorizontalLayout

import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route


@Route("/AllInfoSearch", layout = MainLayout::class)
class AllInfoSearch : Div() {

    private val firstNameField: TextField = TextField("First name")


    private val findButton = Button("find").apply {
        addClickListener {
            Notification.show(PersonRepository.findByFirstName(
                firstNameField.value
            ).toString())
        }
    }


    init {
        add(
            HorizontalLayout().apply {
                add(firstNameField)

            }

        )
    }

    init{
        add(
            HorizontalLayout().apply {
                add(findButton)
            }
        )

    }
}