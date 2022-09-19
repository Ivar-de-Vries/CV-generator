# Stappen voor meewerken met project.
1. Installeer node en angular.
    1. Download en installeer Node.js. Zorg er voor dat de checkbox voor extra software NIET aangevinkt is.
    2. Voer in CMD uit ``` npm install -g @angular/cli ```
2. Clone de repository.
3. Open CMD in een apparte map en voer ``` ng new cv-generator-front-end ``` uit.
    1. Bij de vraag of je routing wil gebruiken. Voer ``` Y ``` in.
    2. Bij de vraag welke type stijl type te gebruiken selecteer je ``` SCSS ``` (Gebruik je pijltjestoetsen).
4. Kopieer de inhoud van de gegenereerde map naar je repository.
5. Er MOET worden gevraagd of je bestanden wil overschrijven. Druk op overslaan.
    1. Als je toch op overschrijven hebt gedrukt, gebruik dan git om de changes te discarden.
6. Open CMD in de map van je project en gebruik ``` ng serve ``` om de server te starten.
7. Ga naar localhost:4200. Als je een pagina ziet, dan is dit gelukt.
8. Als alles nu werkt. Verwijder dan de map die je in stap 3 hebt aangemaakt.
9. Genereren van een CV.
    1. Hiervoor heb je twee npm voor nodig, JsPdf en html2canvas.
    2. Install beide npm in de CMD via ```npm install jspdf --save``` en ```npm install --save html2canvas```


# Angular Readme

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 13.0.2.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
