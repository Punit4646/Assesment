// Dalvadi Punit H


#include <iostream>
#include <string>
#include <iomanip>
#include <cmath>

using namespace std;

int main()
{
    string NameOfEvent, CustomerName;
    double NumberOfGuests;
    int NumberOfMinutes;

    cout << "Enter the name of the event " << endl;
    getline(cin, NameOfEvent);
    cout << "Enter the customer's first and last name " << endl;
    getline(cin, CustomerName);
    cout << "Enter the number of guests " << endl;
    cin >> NumberOfGuests;
    cout << "\n\nEnter the number of minutes in the event " << endl;
    cin >> NumberOfMinutes;

    cout << "Fall Dinner     " << endl;
    cout << "Event estimate for  " << CustomerName << endl;

    int NumberOfServers, Cost1;
    double CostForOneServer, Test, TotalFoodCost, AverageCost, Cost2, DepositAmount, TotalCost;

    const double CostPerHour = 18.50;
    const double CostPerMinute = .40;
    const double CostOfDinner = 20.70;

    Test = NumberOfGuests / 20;
    NumberOfServers = ceil(Test);

    Cost1 = (NumberOfMinutes / 60) * CostPerHour;
    Cost2 = (NumberOfMinutes % 60) * CostPerMinute;
    CostForOneServer = Cost1 + Cost2;

    TotalFoodCost = NumberOfGuests * CostOfDinner;

    AverageCost = TotalFoodCost / NumberOfGuests;

    TotalCost = TotalFoodCost + (CostForOneServer * NumberOfServers);

    DepositAmount = TotalCost * .25;

    cout << "Number Of Server: " << NumberOfServers << fixed << setprecision(2) << endl;
    cout << "The Cost for Servers: " << setw(5) << CostForOneServer << endl;
    cout << "The Cost for Food is: " << setw(5) << TotalFoodCost << endl;
    cout << "Avergae Cost Per Person: " << setw(5) << AverageCost << endl;
    cout << "\nTotal cost is: " << setw(5) << TotalCost << endl;

    cout << "Please deposite a 25% deposit to reserve the event" << endl;
    cout << "The deposit needed is: " << setw(5) << DepositAmount << endl;

    return 0;
}