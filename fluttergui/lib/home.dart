import 'package:flutter/material.dart';

class home extends StatefulWidget {
  const home({super.key});

  @override
  State<home> createState() => _homeState();
}

class _homeState extends State<home> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Home Page",style: TextStyle(color: Colors.white),),
        backgroundColor: Colors.blueAccent,
      ),

      body: Center(
          child: Text("Home page", style: TextStyle(color: Colors.black),),
        ),

    );
  }
}
