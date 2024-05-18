# Tip Calculator

## Overview
<p>Tipping is a way to show your satisfaction and your gratitude for the service you get. However, it's a pain in the neck to calculate the amount of tip, so i had to create a handy tool that will make it easier!</p><br/><br/>

This is a simple Android application that calculates the tip amount based on the bill amount and tip percentage. The app uses `EditText` for user input, a `SeekBar` for selecting the tip percentage, and `TextView`s to display the calculated bill value and tip amount. The tip amount is updated dynamically as the user inputs the bill amount or changes the tip percentage.

## Features
- **Bill Amount Input:** Users can enter the total bill amount.
- **Tip Percentage Selection:** A SeekBar allows users to select the tip percentage.
- **Real-Time Calculation:** The tip amount and total amount are updated in real-time as users input the bill amount and adjust the tip percentage.
- **Validation:** Input validation to handle invalid bill amounts.

## Skills Demonstrated
- **Android Development:** Creating a user interface with XML and managing activities with Kotlin.
- **Event Handling:** Implementing `TextWatcher` for EditText and `SeekBar.OnSeekBarChangeListener` for SeekBar to handle user input events.
- **Data Handling:** Using `BigDecimal` for accurate financial calculations and ensuring proper input validation.
- **UI Design:** Designing a user-friendly interface with proper layout constraints and visibility management.

## Screenshots

![Screenshot](https://github.com/Sieschkie/Tip_Calculator.Kotlin.Android/blob/master/312.png)

## Installation
To use or modify the Tip Calculator app, follow these steps:

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/tip-calculator.git
    ```
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.

## Usage
1. Enter the bill amount in the provided EditText field.
2. Adjust the tip percentage using the SeekBar.
3. View the calculated tip amount and the total amount in the corresponding TextViews.
