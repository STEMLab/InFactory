#!/usr/bin/env python3
# -*- coding: utf-8 -*-
'''check.py: check non ascii charactor.'''

import os
import sys
import argparse
import codecs
import chardet

__author__ = 'Kunlin Yu <yukunlin@syriusrobotics.com>'
__maintainer__ = 'Kunlin Yu <yukunlin@syriusrobotics.com>'

cancel = '\033[00m'
brown = '\033[0;33m'
blue = '\033[0;34m'
cyan = '\033[0;36m'
red = '\033[01;31m'
yellow = '\033[01;33m'
red_bg = '\033[01;41m'

def match_suffix(suffix_list, filename):
    for suffix in suffix_list:
        if filename.endswith(suffix):
            return True
    return False

def ascii_one_file_check(filename):
    f = open(filename, 'rb')
    lines = f.readlines()
    error_count = 0;
    for index, line in enumerate(lines):
        try:
            codecs.decode(line, 'ascii')
        except UnicodeDecodeError:
            #  print('%s%s:%s%s: %serror%s: non-ascii charactor:\n%s' % (cyan, filename, index + 1, cancel, red, cancel, str(line)))
            print('%s%s:%s%s: %snote%s: char detect result:\n%s' % (cyan, filename, index + 1, cancel, blue, cancel, str(line)))
            print(chardet.detect(line))
            error_count += 1
    return error_count;

def ascii_char_check(args):
    suffix_list = ['.py', '.c', '.h', '.cc', '.hh', '.cpp', '.txt', '.xml', 'README', '.md', '.java', 'gml']

    error_count = 0
    for path in args.paths:
        for root, dirs, files in os.walk(path):
            for filename in files:
                if match_suffix(suffix_list, filename):
                    error_count += ascii_one_file_check(os.path.join(root, filename))
    print('ascii char check total error found: ' + str(error_count))
    return error_count

def parse_args(sysargs=None):
    parser = argparse.ArgumentParser(
        description="Utility to aid in building Sirius packages.",
        add_help=True)
    parser.add_argument('--demo', action='store_true', help='demo help')
    parser.add_argument('--paths', choices=None, help='paths name to be check')

    args = parser.parse_args(sysargs[1:])

    if args.paths:
        args.paths = [os.getcwd() + item for item in args.paths.split(',')]
    else:
        args.paths = ["."]

    return args

def main(sysargs):
    args = parse_args(sysargs)
    print(args)

    ascii_char_check(args)

if __name__ == '__main__':
    main(sys.argv)

