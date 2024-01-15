// ignore_for_file: prefer_const_literals_to_create_immutables, prefer_const_constructors

import 'package:flutter/material.dart';
import 'package:fluttersisterrahmi/home.dart';
import 'package:fluttersisterrahmi/mahasiswa/mahasiswa.dart';
import 'package:fluttersisterrahmi/matakuliah/matakuliah.dart';
import 'package:fluttersisterrahmi/nilai/nilai.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Java Service',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blue),
        useMaterial3: true,
      ),
      debugShowCheckedModeBanner: false,
      home: Navbar(),
    );
  }
}

class Navbar extends StatefulWidget {
  const Navbar({super.key});

  @override
  _NavbarState createState() => _NavbarState();
}

class _NavbarState extends State<Navbar> {
  int _currentIndex = 0;
  final List<Widget> _pages = [
    home(),
    DataMahasiswa(),
    DataMatakuliah(),
    DataNilai(),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: _pages[_currentIndex],
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _currentIndex,
        onTap: (index) {
          setState(() {
            _currentIndex = index;
          });
        },
        items: [
          BottomNavigationBarItem(
              icon: Icon(Icons.home),
              label: 'Home',
              backgroundColor: Color.fromARGB(255, 59, 163, 255)),
          BottomNavigationBarItem(
              icon: Icon(Icons.person),
              label: 'Mahasiswa',
              backgroundColor: Color.fromARGB(255, 59, 163, 255)),
          BottomNavigationBarItem(
              icon: Icon(Icons.book_outlined),
              label: 'Matakuliah',
              backgroundColor: Color.fromARGB(255, 59, 163, 255)),
          BottomNavigationBarItem(
              icon: Icon(Icons.numbers),
              label: 'Nilai',
              backgroundColor: Color.fromARGB(255, 117, 82, 243)),
              
        ],
      ),
    );
  }
}
