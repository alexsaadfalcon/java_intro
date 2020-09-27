import os, sys, shutil

docdir = 'docs/'
if not os.path.isdir(docdir):
    os.mkdir(docdir)

for n in range(1, 10):
    hwdir = f'hw{str(n).zfill(2)}'
    print()
    print(hwdir)
    print(os.listdir(hwdir))

    os.chdir(hwdir)
    os.system(f'javadoc *.java -d {hwdir}docs')
    os.chdir('..')

    shutil.move(f'{hwdir}/{hwdir}docs', f'{docdir}/')

    #os.system(f'git add {docdir}/{hwdir}docs')
    #os.system(f'git commit -m"Javadocs for homework {n}"')
